
/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.rsantillanc.pruebaosp.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.rsantillanc.domain.model.UsuarioModel;
import com.rsantillanc.generic.Extra;
import com.rsantillanc.generic.Navigator;
import com.rsantillanc.pruebaosp.R;
import com.rsantillanc.pruebaosp.mvp.presenter.SesionPresenter;
import com.rsantillanc.pruebaosp.mvp.presenter.SesionPresenterImpl;
import com.rsantillanc.pruebaosp.mvp.view.SesionView;
import com.rsantillanc.pruebaosp.ui.interfaces.Inicializador;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class SesionActivity extends SuperActivity implements Inicializador, SesionView {

    /**
     * Lista de vista Logo
     */
    @BindViews({R.id.logo1, R.id.logo2})
    List<AppCompatTextView> logos;

    /**
     * Vista bienvenido.
     */
    @BindView(R.id.tv_bienvenido)
    AppCompatTextView tvBienvenido;

    /**
     * Vista entrada de correo.
     */
    @BindView(R.id.et_correo)
    EditText etCorreo;

    /**
     * Vista botón de inicio de sesión.
     */
    @BindView(R.id.bt_sesion)
    Button btSesion;

    /**
     * Vista que indica que se está ejecutando una tarea en segundo plano.
     */
    @BindView(R.id.progressBar)
    ProgressBar pbCargando;

    /**
     * Presentador de la vista
     */
    SesionPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sesion_activity);

        //Inicial las vistas
        iniciarElementosUI();

        //Hace las configuraciones primarias.
        configurarElementosUI();

        //Animaciones off
        animarBotonSesion(false);

    }

    @Override
    protected void onStart() {
        super.onStart();
        animarLogo(true);
        animarBotonSesion(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        animarBotonSesion(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detener();
    }

    @Override
    public void iniciarElementosUI() {

        //Inicia las vistas
        ButterKnife.bind(this);

        //Inicia el presenter.
        presenter = new SesionPresenterImpl(this);
        presenter.iniciar();
    }

    @Override
    public void configurarElementosUI() {
        configurarBotonInicioSesion();
        configurarCorreo();
    }

    @Override
    public void autenticar(String correo) {
        presenter.autenticar(correo);
    }

    @Override
    public String obtenerCorreo() {
        return etCorreo.getText().toString().trim();
    }

    @Override
    public void configurarCorreo() {

    }

    @Override
    public void configurarBotonInicioSesion() {
        btSesion.setOnClickListener(v -> autenticar(obtenerCorreo()));
    }

    @Override
    public void irActividadPrincipal(UsuarioModel usuarioModel) {
        new Handler().postDelayed(() -> Navigator.irActividadPrincipal(SesionActivity.this, getBundle(usuarioModel), PrincipalActivity.class), 1000);
    }

    //ANIMACIONES

    @Override
    public void animarLogo(boolean si) {

        // 0 = iquierda (Online)
        Animation slideIn = AnimationUtils.loadAnimation(SesionActivity.this, R.anim.anim_right_in);
        logos.get(0).startAnimation(slideIn);

        // 1 = derecha (Studio)
        Animation slideOut = AnimationUtils.loadAnimation(SesionActivity.this, R.anim.anim_left_in);
        logos.get(1).startAnimation(slideOut);
    }

    @Override
    public void animarBotonSesion(boolean si) {
        ViewCompat.animate(btSesion).setStartDelay(si ? 1500 : 0)
                .setDuration(si ? 500 : 0).scaleY(si ? 1 : 0).scaleX(si ? 1 : 0).start();
    }

    @Override
    public void animarError(boolean si) {

    }

    @NonNull
    private Bundle getBundle(UsuarioModel usuarioModel) {
        Bundle b = new Bundle();
        b.putSerializable(Extra.USER, usuarioModel);
        return b;
    }

    @Override
    public Context contx() {
        return getApplicationContext();
    }

    @Override
    public void mostrarCargando(boolean si) {
        pbCargando.setVisibility(si ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void mostrarMensaje(CharSequence sc) {
        mostrarSnack(pbCargando, sc);
    }

    @Override
    public void mostrarError(String message) {
        mostrarSnack(pbCargando, message);
    }

    @Override
    public void mostrarSnack(View v, int resId) {
        Snackbar.make(v, resId, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void mostrarSnack(View v, CharSequence sequence) {
        Snackbar.make(v, sequence, Snackbar.LENGTH_LONG).show();
    }
}
