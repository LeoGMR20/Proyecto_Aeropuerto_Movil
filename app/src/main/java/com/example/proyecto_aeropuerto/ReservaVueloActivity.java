package com.example.proyecto_aeropuerto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proyecto_aeropuerto.databinding.ActivityReservaVueloBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ReservaVueloActivity extends AppCompatActivity {

    //Atributos

    private Date fechaNac;
    private String fechaNacC;
    private ActivityReservaVueloBinding binding;
    private ArrayList<String> tiposDocumento;
    private Vuelo vueloReserva;

    /*Conexión BD*/

    private RequestQueue colaPeticiones;
    private JSONObject parametros;
    private final String URL_BASE = "http://192.168.0.125/univalleDemoB";
    private String endPoint = "/insertarReserva.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_reserva_vuelo);
        binding = ActivityReservaVueloBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Recibir datos vuelo

        vueloReserva = (Vuelo) this.getIntent().getExtras().getSerializable("objeto_vuelo");

        binding.cvFechaNacReserva.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                fechaNacC = i+"/"+i1+"/"+i2;
                try {
                    fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacC);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        binding.btnReservarVuelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvTitReservaVuelo.setText((int) binding.cvFechaNacReserva.getDate());
                reservarVuelo();
            }
        });
    }

    private void reservarVuelo() {
        obtenerInformacion();

        JsonObjectRequest peticionInsercionDatos = new JsonObjectRequest(
                Request.Method.POST,
                URL_BASE + endPoint,
                parametros,
                response -> {
                    try {
                        if (response.get("respuesta").toString().equals("ok")) {
                            Toast.makeText(ReservaVueloActivity.this,
                                    "Reserva guardada correctamente",
                                    Toast.LENGTH_SHORT).show();
                            binding.etNombresReserva.setText("");
                            binding.etApPatReserva.setText("");
                            binding.etApMatReserva.setText("");
                            binding.spTipoDocumentoReserva.setSelection(0);
                            binding.etNumDocumentoReserva.setText("");
                        } else {
                            Toast.makeText(ReservaVueloActivity.this,
                                    "Algo salio mal, pruebe mas tarde",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(ReservaVueloActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
        );
        colaPeticiones.add(peticionInsercionDatos);
    }

    private void obtenerInformacion() {
        parametros = new JSONObject();
        try {
            parametros.put("Nombres", binding.etNombresReserva.getText().toString());
            parametros.put("Apellido_Paterno", binding.etApPatReserva.getText().toString());
            parametros.put("Apellido_Materno", binding.etApMatReserva.getText().toString());
            parametros.put("TipoDocumento", binding.spTipoDocumentoReserva.getSelectedItem().toString());
            parametros.put("NumDocumento", binding.etNombresReserva.getText().toString());
            parametros.put("Fecha_Nac", fechaNac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void popularSpinnerTiposDocumento() {
        tiposDocumento = new ArrayList<>(Arrays.asList("Escoja una opción","CI", "NIT", "Pasaporte"));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                tiposDocumento
        );
        binding.spTipoDocumentoReserva.setAdapter(adaptador);
    }
}