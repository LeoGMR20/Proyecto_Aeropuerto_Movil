package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setContentView(R.layout.activity_bienvenida);
        binding = ActivityBienvenidaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicializarAnimaciones();
        ejecutarAnimaciones();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pasarOtraPantalla();
                finish();
            }
        },10000);
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