package com.rsantillanc.pruebaosp.mvp.view;

import android.content.Context;

/**
 * Created by Renzo D. Santillán Ch. on 22/07/2016.04:04 PM
 * http://rsantillanc.pe.hu/me/
 */
public interface MVPView {
    /**
     * Obtiene un {@link android.content.Context}.
     */
    Context contx();
    void mostrarCargando(boolean si);
    void mostrarMensaje(CharSequence sc);
    void mostrarError(String message);


}
