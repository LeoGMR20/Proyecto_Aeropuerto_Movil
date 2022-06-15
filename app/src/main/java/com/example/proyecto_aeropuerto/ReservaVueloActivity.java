package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.android.volley.RequestQueue;
import com.example.proyecto_aeropuerto.databinding.ActivityReservaVueloBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class ReservaVueloActivity extends AppCompatActivity {

    //Atributos

    private ActivityReservaVueloBinding binding;
    private ArrayList<String> tiposDocumento;
    private RequestQueue colaPeticiones;
    private JSONObject parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_reserva_vuelo);
        binding = ActivityReservaVueloBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnReservarVuelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reservarVuelo();
            }
        });
    }

    private void reservarVuelo() {
        obtenerInformacion();
    }

    private void obtenerInformacion() {
        parametros = new JSONObject();
        try {
            parametros.put("Nombres", binding.etNombresReserva.getText().toString());
            parametros.put("Apellido_Paterno", binding.etApPatReserva.getText().toString());
            parametros.put("Apellido_Materno", binding.etApMatReserva.getText().toString());
            parametros.put("TipoDocumento", binding.spTipoDocumentoReserva.getSelectedItem().toString());
            parametros.put("NumDocumento", binding.etNombresReserva.getText().toString());
            //parametros.put("Fecha_Nac", binding.tvTitReservaVuelo.getDate.toString());
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