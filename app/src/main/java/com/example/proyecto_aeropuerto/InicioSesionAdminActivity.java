package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class InicioSesionAdminActivity extends AppCompatActivity {

    //Componentes visuales

    private TextView tvTituloSignIn;
    private EditText etCod, etClave;
    private Button btnIniciarSesion;
    private Spinner spEmpleado, spAerolinea;

    //Atributos

    private ArrayList<String> opcionesEmpleado, opcionesAerolinea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion_admin);
        inicializarVistas();
        popularSpinnerAerolinea();
        popularSpinnerEmpleado();
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
            }
        });
    }

    private void inicializarVistas() {
        tvTituloSignIn = findViewById(R.id.tvTitulo);
        etCod = findViewById(R.id.etCod);
        etClave = findViewById(R.id.etClave);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        spEmpleado = findViewById(R.id.spEmpleado);
        spAerolinea = findViewById(R.id.spAerolinea);
    }

    private void obtenerInformacion() {
        if(etCod.getText().toString().isEmpty() || etClave.getText().toString().isEmpty()){
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

    private void popularSpinnerEmpleado() {
        opcionesEmpleado = new ArrayList<>(Arrays.asList("Tipo de empleado","Empleado abordaje","Administrador"));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opcionesEmpleado
        );
        spEmpleado.setAdapter(adaptador);
    }

    private void popularSpinnerAerolinea() {
        opcionesAerolinea = new ArrayList<>(Arrays.asList("Aerolinea","BOA","Amazonas","Ecojet"));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opcionesAerolinea
        );
        spAerolinea.setAdapter(adaptador);
    }
}