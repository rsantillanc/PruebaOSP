package com.rsantillanc.data.network.rest.retrofit;

import com.google.gson.JsonObject;
import com.rsantillanc.domain.model.request.SesionRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Renzo D. Santillán Ch. on 22/07/2016.11:19 PM
 * http://rsantillanc.pe.hu/me/
 */
public interface APIService {

    /**
     * Rest - Backendless
     */
    @Headers("Content-Type:application/json")
    @POST("users/login")
    Call<JsonObject> iniciarSesion(@Body SesionRequest cuerpo,
                                   @Header("application-id") String appId,
                                   @Header("secret-key") String secretKey);


}