package com.example.james_pc.app_movil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {

    TextView tvnombre, tvusuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        tvnombre = (TextView) findViewById(R.id.tv_nombre);
        tvusuario = (TextView) findViewById(R.id.tv_usuario);

        Intent intent = new Intent();
        String name = intent.getStringExtra("nombre");
        String carnet = intent.getStringExtra("carnet");

        tvnombre.setText(name);
        tvusuario.setText(carnet);
    }
}
