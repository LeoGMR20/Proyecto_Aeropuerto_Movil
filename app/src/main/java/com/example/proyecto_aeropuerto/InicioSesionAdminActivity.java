package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InicioSesionAdminActivity extends AppCompatActivity {

    //Componentes visuales

    private TextView tvTituloSignIn;
    private EditText etCodAdmin, etClave;
    private Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion_admin);
        inicializarVistas();
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
            }
        });
    }

    private void inicializarVistas() {
        tvTituloSignIn = findViewById(R.id.tvTitulo);
        etCodAdmin = findViewById(R.id.etCodAdmin);
        etClave = findViewById(R.id.etClave);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
    }

    private void obtenerInformacion() {
        if(etCodAdmin.getText().toString().isEmpty() || etClave.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_LONG).show();
        }
        else{
            pasarOtraPantalla();
        }
    }

    private void pasarOtraPantalla() {
        Intent intencionInicioSesionAdmin = new Intent(this,MenuAdminActivity.class);
        startActivity(intencionInicioSesionAdmin);
    }
}