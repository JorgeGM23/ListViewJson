package com.example.jorge.listviewjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter{

    Context contexto; //contexto de la aplicacion
    List<Datos> items; //lista de datos a generar. Podemos usar tb un ArrayList

    public Adaptador(Context contexto, List<Datos> items) {
        this.contexto = contexto;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista=view;
        LayoutInflater inflate = LayoutInflater.from(contexto); //Obtenemos el contexto del item sobre el cual estamos trabajando del ListView
        vista=inflate.inflate(R.layout.item, null); //Consigo referenciar a la vista en sí

        TextView tvFecha = (TextView)vista.findViewById(R.id.tvItemFecha);
        TextView tvDescripcion = (TextView)vista.findViewById(R.id.tvItemDescripcion);
        TextView tvTMax = (TextView)vista.findViewById(R.id.tvItemTMax);
        TextView tvTMin = (TextView)vista.findViewById(R.id.tvITemTMin);

        tvFecha.setText(tvFecha.getText().toString() + " " + items.get(i).getFecha());
        tvTMax.setText(tvTMax.getText().toString() + " " + items.get(i).gettMax());
        tvTMin.setText(tvTMin.getText().toString() + " " + items.get(i).gettMin());
        tvDescripcion.setText(items.get(i).getDescripcion());

        return vista;
    }
}
