package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto_aeropuerto.databinding.ActivityBienvenidaBinding;
import com.example.proyecto_aeropuerto.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Atributos

    private ArrayList<String> opciones;
    private ActivityMainBinding binding;

    //Generar vuelos

    private RequestQueue colaPeticiones;
    private final String URL_BASE = "http://192.168.56.1/peticionesBD";
    private String endPoint1 = "/consultaVuelosSalida.php";
    private String endPoint2 = "/consultaVuelosLlegada.php";

    private ArrayList<Vuelo> vuelosSalida  = new ArrayList<>();
    private ListaVuelosAdapter adaptadorVuelosSalida;
    private ArrayList<Vuelo> vuelosLlegada  = new ArrayList<>();
    private ListaVuelosAdapter adaptadorVuelosLlegada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Cargado de vuelos

        colaPeticiones = Volley.newRequestQueue(this);
        adaptadorVuelosSalida = new ListaVuelosAdapter(vuelosSalida,this);
        binding.lvVuelosSalida.setAdapter(adaptadorVuelosSalida);
        adaptadorVuelosLlegada = new ListaVuelosAdapter(vuelosLlegada,this);
        binding.lvVuelosLlegada.setAdapter(adaptadorVuelosLlegada);
        peticionServicioWeb(endPoint1, vuelosSalida);
        peticionServicioWeb(endPoint2, vuelosLlegada);

        //Evento para el item seleccionado (o no) del spinner
        
        popularSpinnerOpciones();
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

    private void peticionServicioWeb(String endPoint, ArrayList<Vuelo> vuelos) {
        JsonArrayRequest peticionInformacion = new JsonArrayRequest(
                Request.Method.GET,
                URL_BASE+endPoint,
                null,
                response -> {
                    if (response.length() > 0) {
                        Log.d("TAG", response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject objeto = new JSONObject(response.get(i).toString());
                                Vuelo vuelo= new Vuelo(
                                        objeto.getString("Nombre"),
                                        objeto.getString("HoraSalida"),
                                        objeto.getString("HoraLlegada"),
                                        objeto.getInt("CodVuelo"),
                                        objeto.getString("Ciudad"),
                                        objeto.getDouble("Precio")
                                );
                                vuelos.add(vuelo);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                error -> {
                    Toast.makeText(MainActivity.this,
                            error.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
        );
        colaPeticiones.add(peticionInformacion);
    }

    private void popularSpinnerOpciones() {
        opciones = new ArrayList<>(Arrays.asList("Escoja una opción","Inicio", "Vuelos", "Salir"));
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