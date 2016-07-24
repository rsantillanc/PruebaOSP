package com.rsantillanc.pruebaosp.mvp.presenter;

/**
 * Created by Renzo D. Santillán Ch. on 22/07/2016.05:17 PM
 * http://rsantillanc.pe.hu/me/
 */
public interface SesionPresenter {
    void autenticar(String correo);
    void iniciar();
    void detener();
}
