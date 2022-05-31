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

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Atributos

    private ArrayList<String> opciones;

    //Componentes visuales
    private TextView tvTitulo;
    private ImageView ivAvionMain;
    private Spinner spOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        popularSpinnerOpciones();
        //Evento para el item seleccionado (o no) del spinner
        spOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pasarOtraPantalla(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void inicializarVistas() {
        tvTitulo = findViewById(R.id.tvTitulo);
        ivAvionMain = findViewById(R.id.ivAvionMain);
        spOpciones = findViewById(R.id.spOpciones);
    }

    private void popularSpinnerOpciones() {
        opciones = new ArrayList<>(Arrays.asList("Escoja una opción","Inicio", "Check In", "Equipaje",
                "Pet Check", "Control de aeronaves","Iniciar sesión"));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );
        spOpciones.setAdapter(adaptador);
    }

    private void pasarOtraPantalla(int seleccion){
        Intent intencionMain;
        switch (seleccion){
            /*case 0:
                Toast.makeText(this, "Escoja una opción", Toast.LENGTH_LONG).show();
                break;*/
            case 1:
                intencionMain = new Intent(this,MainActivity.class);
                startActivity(intencionMain);
                break;
            /*case 2:
                intencionMain = new Intent(this,CheckInActivity.class);
                startActivity(intencionMain);
                break;
            case 3:
                intencionMain = new Intent(this,EquipajeActivity.class);
                startActivity(intencionMain);
                break;
            case 4:
                intencionMain = new Intent(this,PetCheckActivity.class);
                startActivity(intencionMain);
                break;
            case 5:
                intencionMain = new Intent(this,ControlAeronavesActivity.class);
                startActivity(intencionMain);
                break;
            case 6:
                intencionMain = new Intent(this,InicioSesionActivity.class);
                startActivity(intencionMain);
                break;*/
        }
    }
}