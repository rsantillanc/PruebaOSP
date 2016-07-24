package com.rsantillanc.generic;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by Renzo D. Santillán Ch. on 24/07/2016.11:18 AM
 * http://rsantillanc.pe.hu/me/
 */
public class Mapper {

    /**
     * Método Generico para transformar un String a un objeto que se indique.
     *
     * @param string     String que representa el objeto
     * @param classModel Tipo de modelo de objeto que se desea convertir
     * @param <T>        Tipo generico
     * @return una Entidad
     */
    public static <T> T transformarModelo(@NonNull final String string, @NonNull final Class<T> classModel) {
        return new Gson().fromJson(string, classModel);
    }

    /**
     * Método Generico para transformar un String a un objeto que se indique.
     *
     * @param body       JsonObject que representa el modelo
     * @param classModel Tipo de modelo de objeto que se desea convertir
     * @param <T>        Tipo generico
     * @return una Entidad
     */
    public static <T> T transformarModelo(@NonNull final JsonObject body, @NonNull final Class<T> classModel) {
        return new Gson().fromJson(body, classModel);
    }
}
