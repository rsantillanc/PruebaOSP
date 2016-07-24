package com.rsantillanc.data.network.rest.retrofit;

import android.content.Context;

import com.google.gson.JsonObject;
import com.rsantillanc.domain.model.request.SesionRequest;

import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.06:23 PM
 * http://rsantillanc.pe.hu/me/
 */
public class RetrofitImpl {


    public void iniciarSesion(SesionRequest cuerpo, Context c, String appId, String secretKey, Callback<JsonObject> evento) {
        RetrofitFactory
                .getApi(GsonConverterFactory.create(), c)
                .iniciarSesion(cuerpo, appId, secretKey)
                .enqueue(evento);
    }


}
