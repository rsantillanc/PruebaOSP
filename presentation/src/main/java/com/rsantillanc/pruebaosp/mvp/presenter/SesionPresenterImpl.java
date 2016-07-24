package com.rsantillanc.pruebaosp.mvp.presenter;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rsantillanc.data.repository.UsuarioDataRepository;
import com.rsantillanc.domain.model.UsuarioModel;
import com.rsantillanc.domain.usecase.AutenticarUseCase;
import com.rsantillanc.pruebaosp.mvp.view.SesionView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Renzo D. Santillán Ch. on 22/07/2016.05:17 PM
 * http://rsantillanc.pe.hu/me/
 */
public class SesionPresenterImpl implements SesionPresenter, Callback<JsonObject> {

    SesionView sesionView;
    AutenticarUseCase iniciarSesionUseCase;

    /**
     * Constructor, injector
     *
     * @param principalView Vista (MVP)
     */
    public SesionPresenterImpl(SesionView principalView) {
        sesionView = principalView;
    }

    @Override
    public void autenticar(String correo) {
        sesionView.mostrarCargando(true);
        iniciarSesionUseCase.autenticar(correo, "clave", this);
    }

    @Override
    public void iniciar() {
        iniciarSesionUseCase = new AutenticarUseCase(getContx(), new UsuarioDataRepository(getContx()));
    }

    @Override
    public void detener() {
        iniciarSesionUseCase = null;
    }


    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        sesionView.mostrarCargando(false);
        sesionView.mostrarMensaje(response.message());
        if (response.body() != null)
            sesionView.irActividadPrincipal(transformarModelo(response.body()));
    }

    private UsuarioModel transformarModelo(JsonObject modeloJson) {
        return new Gson().fromJson(modeloJson, UsuarioModel.class);
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {
        sesionView.mostrarCargando(false);
        sesionView.mostrarError(t.getMessage());
    }

    public Context getContx() {
        return sesionView.contx();
    }
}
