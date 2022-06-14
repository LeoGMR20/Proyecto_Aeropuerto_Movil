package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.android.volley.RequestQueue;
import com.example.proyecto_aeropuerto.databinding.ActivityEquipajeBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class EquipajeActivity extends AppCompatActivity {

    private ActivityEquipajeBinding binding;
    private RequestQueue colaPeticiones;
    private JSONObject parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_equipaje);
        binding = ActivityEquipajeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnRegistrarEquipaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarEquipaje();
            }
        });
    }

    private void registrarEquipaje() {
        obtenerInformacion();
    }

    private void obtenerInformacion() {
        /*parametros = new JSONObject();
        try {
            parametros.put("TipoEquipaje", binding.spTipoEquipaje.getSelectedItem().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
}