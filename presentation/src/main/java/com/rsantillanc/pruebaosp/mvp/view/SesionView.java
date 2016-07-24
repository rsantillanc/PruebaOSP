package com.rsantillanc.pruebaosp.mvp.view;

import com.rsantillanc.domain.model.UsuarioModel;

/**
 * Created by Renzo D. Santillán Ch. on 22/07/2016.04:03 PM
 * http://rsantillanc.pe.hu/me/
 */
public interface SesionView extends MVPView {
    void autenticar(String correo);
    String obtenerCorreo();
    void configurarBotonInicioSesion();
    void habilitarBotonInicioSesion(boolean si);
    void irActividadPrincipal(UsuarioModel usuarioModel);
    void animarLogo(boolean si);
    void animarBotonSesion(boolean si);
    void animarError(boolean si);
}
