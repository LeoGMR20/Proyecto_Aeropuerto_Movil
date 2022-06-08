package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.proyecto_aeropuerto.databinding.ActivityBienvenidaBinding;

import java.util.Timer;

public class BienvenidaActivity extends AppCompatActivity {

    //Atributos

    private ActivityBienvenidaBinding binding;
    private Animation transparencia;
    private Intent intencion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_bienvenida);
        binding = ActivityBienvenidaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicializarAnimaciones();
        ejecutarAnimaciones();
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        pasarOtraPantalla();
    }


    private void inicializarAnimaciones() {
        transparencia = AnimationUtils.loadAnimation(this,R.anim.bienvenida);
    }

    private void ejecutarAnimaciones() {
        transparencia.setDuration(10000);
        binding.tvBienvenida.startAnimation(transparencia);
    }

    private void pasarOtraPantalla() {

        intencion = new Intent(this,MainActivity.class);
        startActivity(intencion);
    }
}