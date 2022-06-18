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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto_aeropuerto.databinding.ActivityMainBinding;
import com.example.proyecto_aeropuerto.databinding.ActivityVuelosBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class VuelosActivity extends AppCompatActivity {

    //Atributos

    private ActivityVuelosBinding binding;
    private ArrayList<String> opciones = new ArrayList<>();
    Bundle filtroMain;
    int valAerolinea;

    //Generar vuelos

    private RequestQueue colaPeticiones;

    private ArrayList<Vuelo> vuelos = new ArrayList<>();
    private ListaVuelosAdapter adaptadorVuelos;

    private final String URL_BASE = "http://192.168.56.1/peticionesBD";
    private String endPoint = "/consultaVuelosSalida.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVuelosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        popularSpinnerOpciones();

        //Filtrado
        /*filtroMain = getIntent().getExtras();
        valAerolinea = filtroMain.getInt("filtroAerolinea");*/

        //-------

        colaPeticiones = Volley.newRequestQueue(this);
        adaptadorVuelos = new ListaVuelosAdapter(vuelos,this);
        binding.lvVuelos.setAdapter(adaptadorVuelos);
        try{
            peticionServicioWeb();
        }
        catch (Exception E){
            Toast.makeText(this, E.getMessage(), Toast.LENGTH_SHORT).show();
        }

        //Clicks

        binding.spOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pasarOtraPantalla(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.lvVuelos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                irAReservarVuelo(i);
            }
        });
    }

    private void peticionServicioWeb() {
        JsonArrayRequest peticionInformacion = new JsonArrayRequest(
                Request.Method.GET,
                URL_BASE+ endPoint,
                null,
                response -> {
                    if (response.length() > 0) {
                        Log.d("TAG", response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject objeto = new JSONObject(response.get(i).toString());
                                Vuelo vuelo = new Vuelo(
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
                    Toast.makeText(VuelosActivity.this,
                            error.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
        );
        colaPeticiones.add(peticionInformacion);
    }

    private void irAReservarVuelo(int pos) {
        Intent intencionReservar = new Intent(this,ReservaVueloActivity.class);
        Bundle archivoTemporal = new Bundle();
        archivoTemporal.putSerializable("objeto_vuelo", vuelos.get(pos));
        intencionReservar.putExtras(archivoTemporal);
        startActivity(intencionReservar);
    }

    private void popularSpinnerOpciones() {
        opciones = new ArrayList<>(Arrays.asList("Escoja una opción","Inicio", "Vuelos"));
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
        }
    }
}