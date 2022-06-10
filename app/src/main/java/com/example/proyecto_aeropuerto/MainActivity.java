package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_aeropuerto.databinding.ActivityBienvenidaBinding;
import com.example.proyecto_aeropuerto.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Atributos

    private ArrayList<String> opciones;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        popularSpinnerOpciones();
        //Evento para el item seleccionado (o no) del spinner
        binding.spOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pasarOtraPantalla(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Botones aerolíneas

        binding.btnBoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vuelos(1);
            }
        });
        binding.btnAmazonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vuelos(2);
            }
        });
        binding.btnEcojet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vuelos(3);
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

    private void vuelos(int val) {
    }
}