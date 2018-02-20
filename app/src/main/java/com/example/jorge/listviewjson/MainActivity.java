package com.example.jorge.listviewjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Datos> listaDatos;
    ListView listView;

    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?id=3130616&APPID=f13fdba45983a01b4aa61b4bf120aa5b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listaDatos = new ArrayList<>();
        this.listView = (ListView) findViewById(R.id.listview);

        Toast.makeText(this, "Antes del request", Toast.LENGTH_SHORT).show();
        RequestQueue request = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(getApplicationContext(), "entrando en el onresponse", Toast.LENGTH_SHORT).show();
                    // creo objeto y luego voy haciendo set
                    Datos dato = new Datos();
                    JSONObject objetoJsonPrincipal = new JSONObject(response.toString(0));
                    // cojo el array
                    JSONArray arrayJsonPrincipal = objetoJsonPrincipal.getJSONArray("list");
                    // recorro el array
                    Toast.makeText(getApplicationContext(), "recorro el array", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < arrayJsonPrincipal.length(); i++) {
                        String temp_max = arrayJsonPrincipal.getJSONObject(i).getJSONObject("main").getString("temp_max");
                        String temp_min = arrayJsonPrincipal.getJSONObject(i).getJSONObject("main").getString("temp_min");
                        dato.settMax(temp_max);
                        dato.settMin(temp_min);
                        String descripcion = arrayJsonPrincipal.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
                        dato.setDescripcion(descripcion);
                        String fecha = arrayJsonPrincipal.getJSONObject(i).getString("dt_txt");
                        dato.setFecha(fecha);
                        listaDatos.add(dato);
                        //Toast.makeText(getApplicationContext(), fecha, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {}

        });
        request.add(jsonObjectRequest);

        Toast.makeText(this, "meto la lista en el adaptador", Toast.LENGTH_SHORT).show();

        for (int i = 0; i < listaDatos.size(); i++) {
            System.out.println(listaDatos.get(i).getFecha());
        }

        Adaptador miAdaptador=new Adaptador(getApplicationContext(), listaDatos);

        listView.setAdapter(miAdaptador);
    }


}

