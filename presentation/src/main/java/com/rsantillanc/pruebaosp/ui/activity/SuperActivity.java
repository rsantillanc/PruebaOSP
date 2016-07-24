package com.rsantillanc.pruebaosp.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Renzo D. Santillán Ch. on 22/07/2016.12:20 PM
 * http://rsantillanc.pe.hu/me/
 */
public abstract class SuperActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    // MENSAJES - SNACK
    public abstract void mostrarSnack(View v, int resId);
    public abstract void mostrarSnack(View v, CharSequence sequence);

    public void mostrarSnack(int resId, View v) {

    }


}
