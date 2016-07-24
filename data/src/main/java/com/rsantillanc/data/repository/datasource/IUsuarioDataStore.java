package com.rsantillanc.data.repository.datasource;

import android.content.Context;

import com.google.gson.JsonObject;
import com.rsantillanc.domain.model.request.SesionRequest;

import retrofit2.Callback;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.06:20 PM
 * http://rsantillanc.pe.hu/me/
 */
public interface IUsuarioDataStore {
    void sesion(SesionRequest credenciales, Callback<JsonObject> evento, Context c);
}
