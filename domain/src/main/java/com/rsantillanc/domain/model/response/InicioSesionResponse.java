package com.rsantillanc.domain.model.response;

import com.rsantillanc.domain.model.UsuarioModel;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.02:41 PM
 * http://rsantillanc.pe.hu/me/
 */
public class InicioSesionResponse extends SuperResponse {

   private UsuarioModel usuario;

    public UsuarioModel getUsuario() {
        return usuario;
    }


}
