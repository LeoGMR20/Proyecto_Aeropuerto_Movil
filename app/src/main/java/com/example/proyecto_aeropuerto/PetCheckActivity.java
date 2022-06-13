package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.proyecto_aeropuerto.databinding.ActivityBienvenidaBinding;
import com.example.proyecto_aeropuerto.databinding.ActivityPetCheckBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class PetCheckActivity extends AppCompatActivity {

    //Atributos

    private ArrayList<String> opciones;
    private ActivityPetCheckBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_pet_check);
        binding = ActivityPetCheckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        popularSpinnerMascotas();
        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarMascota();
            }
        });
    }

    private void popularSpinnerMascotas() {
        opciones = new ArrayList<>(Arrays.asList("Perro", "Gato", "Pajaro", "Otro"));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );
        binding.spEspecieMascota.setAdapter(adaptador);
    }

    private void registrarMascota() {
    }
}