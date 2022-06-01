package com.example.proyecto_aeropuerto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAdminActivity extends AppCompatActivity {

    //Componentes Visuales

    private EditText etCI, etNombres, etApPat, etApMat, etClave2, etConfirmarClave;
    private Button btnAddAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);
        inicializarVistas();
        btnAddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
            }
        });
    }

    private void inicializarVistas() {
        etCI = findViewById(R.id.etCI);
        etNombres = findViewById(R.id.etNombres);
        etApPat = findViewById(R.id.etApPat);
        etApMat = findViewById(R.id.etApMat);
        etClave2 = findViewById(R.id.etClave2);
        etConfirmarClave = findViewById(R.id.etConfirmarClave);
        btnAddAdmin = findViewById(R.id.btnAddAdmin);
    }

    private void obtenerInformacion() {
        if(etCI.getText().toString().isEmpty() ||
                etNombres.getText().toString().isEmpty() ||
                (etApPat.getText().toString().isEmpty() &&
                        etApMat.getText().toString().isEmpty()) ||
                etClave2.getText().toString().isEmpty() ||
                etConfirmarClave.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese todos los datos", Toast.LENGTH_LONG).show();
        }
        else if(etCI.getText().toString().length() < 7){
            Toast.makeText(this, "El CI ingresado es demasiado pequeño", Toast.LENGTH_LONG).show();
        }
        else if(etNombres.getText().toString().length() < 3){
            Toast.makeText(this, "Nombre(s) ingresado(s) demasiado(s) pequeño(s)", Toast.LENGTH_LONG).show();
        }
        else if(etApPat.getText().toString().length() < 3 ||
                etApMat.getText().toString().length() < 3) {
            Toast.makeText(this, "Apellido Paterno o materno ingresados son demasiados pequeños", Toast.LENGTH_LONG).show();
        }
        else if(etClave2.getText().toString().length() < 8) {
            Toast.makeText(this, "Contraseña ingresada demasiada pequeña", Toast.LENGTH_LONG).show();
        }
        else if(etConfirmarClave.getText().toString().equals(etClave2.getText().toString())) {
            Toast.makeText(this, "El CI ingresado es demasiado pequeño", Toast.LENGTH_LONG).show();
        }
        else{

        }
    }
}
