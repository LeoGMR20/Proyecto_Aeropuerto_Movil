package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuAdminActivity extends AppCompatActivity {

    //Componentes Visuales

    private TextView tvTitMenuAdmin;
    private Button btnAddAdministrador, btnAddVuelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        inicializarVistas();
        btnAddAdministrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarOtraPantalla(1);
            }
        });
    }

    private void inicializarVistas() {
        tvTitMenuAdmin = findViewById(R.id.tvTitMenuAdmin);
        btnAddAdministrador = findViewById(R.id.btnAddAdministrador);
        btnAddVuelo = findViewById(R.id.btnAddVuelo);
    }

    private void pasarOtraPantalla(int pantalla) {
        Intent intencionAdmin;
        switch (pantalla){
            case 1:
                /*intencionAdmin = new Intent(this.AddAdmin.class);
                startActivity(intencionAdmin);*/
                break;
            case 2:
                /*intencionAdmin = new Intent(this.AddVuelo.class);
                startActivity(intencionAdmin);*/
                break;
        }
    }
}