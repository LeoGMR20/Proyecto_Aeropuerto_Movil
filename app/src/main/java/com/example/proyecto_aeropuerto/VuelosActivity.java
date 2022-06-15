package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.proyecto_aeropuerto.databinding.ActivityMainBinding;
import com.example.proyecto_aeropuerto.databinding.ActivityVuelosBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class VuelosActivity extends AppCompatActivity {

    //Atributos

    private ActivityVuelosBinding binding;
    private ArrayList<String> opciones;
    Bundle filtroMain;
    int valAerolinea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVuelosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        popularSpinnerOpciones();
        filtroMain = getIntent().getExtras();
        valAerolinea = filtroMain.getInt("filtroAerolinea");
        binding.spOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pasarOtraPantalla(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void popularSpinnerOpciones() {
        opciones = new ArrayList<>(Arrays.asList("Escoja una opción","Inicio", "Vuelos", "Iniciar sesión"));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );
        binding.spOpciones.setAdapter(adaptador);
    }

    private void pasarOtraPantalla(int seleccion){
        Intent intencionMain;
        switch (seleccion){
            case 0:
                Toast.makeText(this, "Escoja una opción", Toast.LENGTH_LONG).show();
                break;
            case 1:
                intencionMain = new Intent(this,MainActivity.class);
                startActivity(intencionMain);
                break;
            case 2:
                intencionMain = new Intent(this,VuelosActivity.class);
                startActivity(intencionMain);
                break;
            case 3:
                intencionMain = new Intent(this,InicioSesionAdminActivity.class);
                startActivity(intencionMain);
                break;
        }
    }
}