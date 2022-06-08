package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyecto_aeropuerto.databinding.ActivityBienvenidaBinding;
import com.example.proyecto_aeropuerto.databinding.ActivityPetCheckBinding;

public class PetCheckActivity extends AppCompatActivity {

    //Atributos

    private ActivityPetCheckBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_pet_check);
        binding = ActivityPetCheckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}