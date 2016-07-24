package com.rsantillanc.domain.repocitory;


import com.google.gson.JsonObject;

import retrofit2.Callback;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.05:48 PM
 * http://rsantillanc.pe.hu/me/
 */
public interface UsuarioRepocitory {
    void iniciarSesion(String identificadorUnico, String contraseña, Callback<JsonObject> evento);
}
