package com.example.proyecto_aeropuerto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.proyecto_aeropuerto.databinding.VuelosSalidaBinding;

import java.util.ArrayList;

public class ListaVuelosAdapter extends BaseAdapter {

    //Atrbitos

    private ArrayList<Vuelo> vuelos;
    private VuelosSalidaBinding vueloBinding;
    private Context contexto;

    public ListaVuelosAdapter(ArrayList<Vuelo> vuelos, Context contexto) {
        this.vuelos = vuelos;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return vuelos.size();
    }

    @Override
    public Object getItem(int i) {
        return vuelos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView == null){
            ///Lo vas a dibujar de cero
            vueloBinding = vueloBinding.inflate(LayoutInflater.from(contexto), viewGroup, false); //getLayoutInflater() solo existe en una actividad
            holder = new ViewHolder(vueloBinding);
            convertView = holder.view;
            //Memorizar como etiqueta ese objeto para este diseño
            convertView.setTag(holder);
        }else{
            //Cuando no es nulo usa el que ya tienes
            holder = (ViewHolder) convertView.getTag();
        }
        /*holder.binding.txtDenominacion.setText(productos.get(position).getDenominacion());
        holder.binding.txtCategoria.setText(productos.get(position).getCategoria());
        holder.binding.txtPrecio.setText(String.valueOf(productos.get(position).getPrecio()));*/
        return convertView;
    }

    public static class ViewHolder{
        //Para mapear o memorizar tus vistas que vas a dibujar y los valores que le asocias.
        private View view;
        private VuelosSalidaBinding binding; //Vista mapeada

        public ViewHolder(VuelosSalidaBinding binding){
            this.binding = binding;
            this.view = binding.getRoot();//R.layout.producto_item
        }
    }
}