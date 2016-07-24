package com.rsantillanc.domain.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.02:42 PM
 * http://rsantillanc.pe.hu/me/
 */
public class ErrorModel implements Serializable {
    private static final long serialVersionUID = 0L;

    @SerializedName("message")
    private String mensaje;

    @SerializedName("code")
    private int codigo;


    public ErrorModel(String mensaje, int codigo) {
        this.mensaje = mensaje;
        this.codigo = codigo;
    }

    public ErrorModel() {
    }



    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "ErrorModel{" +
                "mensaje='" + mensaje + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
