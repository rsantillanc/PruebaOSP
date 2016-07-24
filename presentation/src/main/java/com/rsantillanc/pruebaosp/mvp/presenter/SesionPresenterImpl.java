package com.rsantillanc.pruebaosp.mvp.presenter;


import android.content.Context;

import com.google.gson.JsonObject;
import com.rsantillanc.data.repository.UsuarioDataRepository;
import com.rsantillanc.domain.model.ErrorModel;
import com.rsantillanc.domain.model.UsuarioModel;
import com.rsantillanc.domain.usecase.AutenticarUseCase;
import com.rsantillanc.generic.Mapper;
import com.rsantillanc.pruebaosp.mvp.view.SesionView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Renzo D. Santillán Ch. on 22/07/2016.05:17 PM
 * http://rsantillanc.pe.hu/me/
 */
public class SesionPresenterImpl implements SesionPresenter, Callback<JsonObject> {

    /**
     * Vista de sesion (MVP)
     */
    SesionView sesionView;

    /**
     * Lógica de negocio o caso de uso (TCA)
     */
    AutenticarUseCase iniciarSesionUseCase;

    /**
     * Constructor, injector
     *
     * @param principalView Vista (MVP)
     */
    public SesionPresenterImpl(SesionView principalView) {
        sesionView = principalView;
    }

    /**
     * @return Contexto de la aplicacion
     */

    public Context getContx() {
        return sesionView.contx();
    }

    /**
     * Método que autentica al usuario
     * @param correo correo del usuario
     */
    @Override
    public void autenticar(String correo) {
        sesionView.mostrarCargando(true);
        sesionView.habilitarBotonInicioSesion(false);
        iniciarSesionUseCase.autenticar(correo, "clave", this);
    }

    /**
     * Instancia el caso de uso
     */
    @Override
    public void iniciar() {
        iniciarSesionUseCase = new AutenticarUseCase(getContx(), new UsuarioDataRepository(getContx()));
    }

    /**
     * Nulea el caso de uso
     */
    @Override
    public void detener() {
        iniciarSesionUseCase = null;
    }

    /**
     * Devolución de llamadas usando retrofit.
     * Se debería usar una devolución de llamada customizada.
     * @param call Objeto call de retrofit
     * @param response Respuesta de retrofit
     */
    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

        //Habilitar controles
        sesionView.mostrarCargando(false);
        sesionView.habilitarBotonInicioSesion(true);

        //Manejo de respuesta
        if (response.body() != null) {
            sesionView.mostrarMensaje(response.message());
            sesionView.irActividadPrincipal(Mapper.transformarModelo(response.body(), UsuarioModel.class));
        } else {
            sesionView.animarError(true);
            try {
                ErrorModel error = Mapper.transformarModelo(response.errorBody().string(), ErrorModel.class);
                sesionView.mostrarMensaje(error.getMensaje());
            } catch (IOException e) {
                sesionView.mostrarMensaje(response.raw().message());
                e.printStackTrace();
            }
        }
    }

    /**
     * Devolución de llamadas usando retrofit.
     * Aquí se puede indicar un tryAgain sin necesidad de presionar {@link android.widget.Button btSesion}.
     * @param call Objeto call de retrofit
     * @param  t Error de respuesta en retrofit
     */
    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {
        //Manejo de respuesta & controles
        sesionView.habilitarBotonInicioSesion(true);
        sesionView.mostrarCargando(false);
        sesionView.mostrarError(t.getMessage());
        sesionView.animarError(true);
    }

}
