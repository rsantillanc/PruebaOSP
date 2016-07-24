package com.rsantillanc.data.repository.datasource;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.06:39 PM
 * http://rsantillanc.pe.hu/me/
 */
public class UsuarioDataFactory {

    public IUsuarioDataStore crearInicioSesionRest() {
        return new UsuarioRestDataSource();
    }
}
