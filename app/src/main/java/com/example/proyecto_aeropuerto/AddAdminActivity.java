package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddAdminActivity extends AppCompatActivity {

    //Componentes Visuales

    private EditText etCI, etNombres, etApPat, etApMat, etClave2, etConfirmarClave;
    private Button btnAddAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);
        inicializarVistas();
    }

    private void inicializarVistas() {
    }
}