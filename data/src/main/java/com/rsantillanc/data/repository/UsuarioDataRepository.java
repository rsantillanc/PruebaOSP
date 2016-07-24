package com.rsantillanc.data.repository;

import android.content.Context;

import com.google.gson.JsonObject;
import com.rsantillanc.data.repository.datasource.IUsuarioDataStore;
import com.rsantillanc.data.repository.datasource.UsuarioDataFactory;
import com.rsantillanc.domain.model.request.SesionRequest;
import com.rsantillanc.domain.repocitory.UsuarioRepocitory;

import retrofit2.Callback;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.05:44 PM
 * http://rsantillanc.pe.hu/me/
 */
public class UsuarioDataRepository implements UsuarioRepocitory {

    final UsuarioDataFactory fabrica = new UsuarioDataFactory();
    final Context contx;

    public UsuarioDataRepository(Context c) {
        this.contx = c;
    }

    private SesionRequest crearParametrosAutenticacion(String id, String contraseña) {
        SesionRequest rq = new SesionRequest();
        rq.setIdentidad(id);
        rq.setClave(contraseña);
        return rq;
    }

    @Override
    public void iniciarSesion(String identificadorUnico, String contraseña, Callback<JsonObject> evento) {
        IUsuarioDataStore uds = fabrica.crearInicioSesionRest();
        uds.sesion(crearParametrosAutenticacion(identificadorUnico, contraseña), evento, this.contx);
    }
}
