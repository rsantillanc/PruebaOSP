package com.rsantillanc.domain.model;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Renzo D. Santillán Ch. on 22/07/2016.03:57 PM
 * http://rsantillanc.pe.hu/me/
 */
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 0L;

    @SerializedName("objectId")
    private String id;

    @SerializedName("user-token")
    private String token;

    @SerializedName("name")
    private String nombre;


    public UsuarioModel(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
