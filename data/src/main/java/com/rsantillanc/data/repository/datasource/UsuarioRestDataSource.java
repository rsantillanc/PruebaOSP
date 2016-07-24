package com.rsantillanc.data.repository.datasource;

import android.content.Context;

import com.google.gson.JsonObject;
import com.rsantillanc.data.R;
import com.rsantillanc.data.network.rest.retrofit.RetrofitImpl;
import com.rsantillanc.domain.model.request.SesionRequest;

import retrofit2.Callback;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.06:18 PM
 * http://rsantillanc.pe.hu/me/
 */
public class UsuarioRestDataSource implements IUsuarioDataStore {

    RetrofitImpl restService;

    public UsuarioRestDataSource() {
        restService = new RetrofitImpl();
    }

    @Override
    public void sesion(SesionRequest credenciales, Callback<JsonObject> evento, Context c) {
        restService.iniciarSesion(credenciales, c, obtenerAppId(c), obtenerSecretKey(c), evento);
    }

    private String obtenerSecretKey(Context c) {
        return c.getString(R.string.secret_key_backendless);
    }

    private String obtenerAppId(Context c) {
        return c.getString(R.string.app_id_backendless);
    }


}
