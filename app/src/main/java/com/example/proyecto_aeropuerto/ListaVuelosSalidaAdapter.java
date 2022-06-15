package com.example.proyecto_aeropuerto;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.proyecto_aeropuerto.databinding.VuelosSalidaBinding;

import java.util.ArrayList;

public class ListaVuelosSalidaAdapter extends BaseAdapter {

    //Atributos

    private ArrayList<Vuelo> vuelos;
    private VuelosSalidaBinding vueloBinding;
    private Context contexto;

    public ListaVuelosSalidaAdapter(ArrayList<Vuelo> vuelos, Context contexto) {
        this.vuelos = vuelos;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
