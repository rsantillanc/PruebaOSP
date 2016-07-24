package com.rsantillanc.generic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Renzo D. Santillán Ch. on 24/07/2016.03:34 AM
 * http://rsantillanc.pe.hu/me/
 */
public class Navigator {

    /**
     * Este método generico permite ir de un lugar x hacia la main activity
     * @param actvt actividad desde donde se invoca al método.
     * @param data objeto Bundle con con posible data.
     * @param clazz Actividad.class donde se pretende ir.
     */
    public static void irActividadPrincipal(@NonNull Activity actvt, @Nullable Bundle data, Class<?> clazz) {
        Intent ir = new Intent(actvt, clazz);
        if (data!=null){
            ir.putExtras(data);
        }
        ir.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        actvt.startActivity(ir);
        actvt.finish();
    }
}
