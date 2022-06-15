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

    //Generar vuelos

    private ArrayList<Vuelo> vuelosSalida;
    private ListaVuelosSalidaAdapter adaptadorVuelosSalida;
    private ArrayList<Vuelo> vuelosLlegada;
    private ListaVuelosLlegadaAdapter adaptadorVuelosLlegada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Cargado de vuelos

        adaptadorVuelosSalida = new ListaVuelosSalidaAdapter(vuelosSalida,this);
        binding.lvVuelosSalida.setAdapter(adaptadorVuelosSalida);
        adaptadorVuelosLlegada = new ListaVuelosLlegadaAdapter(vuelosLlegada,this);
        binding.lvVuelosLlegada.setAdapter(adaptadorVuelosLlegada);

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
        opciones = new ArrayList<>(Arrays.asList("Escoja una opción","Inicio", "Vuelos", "Iniciar sesión", "Salir"));
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
            case 4:
                salir();
                break;
        }
    }

    private void vuelos(int val) {
        Intent intencionVuelo = new Intent(this, VuelosActivity.class);
        intencionVuelo.putExtra("filtroAerolinea",val);
        startActivity(intencionVuelo);
    }

    /*Métodos para salir de la aplicación*/

    private void salir() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de la aplicación?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            salir();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}