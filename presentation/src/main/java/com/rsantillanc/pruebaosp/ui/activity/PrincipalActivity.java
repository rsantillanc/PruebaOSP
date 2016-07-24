package com.rsantillanc.pruebaosp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.rsantillanc.domain.model.UsuarioModel;
import com.rsantillanc.generic.Extra;
import com.rsantillanc.pruebaosp.R;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_activity);
        ((TextView) findViewById(R.id.tv_id)).setText(((UsuarioModel) getIntent().getSerializableExtra(Extra.USER)).getNombre());
    }
}
