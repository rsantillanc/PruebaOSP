package com.rsantillanc.domain.usecase;

import android.content.Context;

import com.google.gson.JsonObject;
import com.rsantillanc.domain.repocitory.UsuarioRepocitory;

import retrofit2.Callback;

/**
 * Created by Renzo D. Santillán Ch. on 22/07/2016.11:10 PM
 * http://rsantillanc.pe.hu/me/
 */
public class AutenticarUseCase extends UseCase {

    final Context contx;
    UsuarioRepocitory repocitorio;

    public AutenticarUseCase(Context c,UsuarioRepocitory rep) {
        this.contx = c;
        this.repocitorio = rep;
    }

    public void autenticar(String id, String clave, Callback<JsonObject> evento) {
        repocitorio.iniciarSesion(id, clave, evento);
    }


}
