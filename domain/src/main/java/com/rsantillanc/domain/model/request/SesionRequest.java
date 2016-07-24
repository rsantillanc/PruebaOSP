package com.rsantillanc.domain.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.05:27 PM
 * http://rsantillanc.pe.hu/me/
 */
public class SesionRequest {

    @SerializedName("password")
    private String clave ;
    @SerializedName("login")
    private String identidad;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }
}
