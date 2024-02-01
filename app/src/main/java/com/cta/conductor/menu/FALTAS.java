package com.cta.conductor.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.cta.conductor.LOGIN;
import com.cta.conductor.MENU;
import com.cta.conductor.R;
import com.cta.conductor.menu.info_menufalta.FaltaAdapter;
import com.cta.conductor.menu.info_menufalta.FaltaLista;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class FALTAS extends AppCompatActivity implements View.OnClickListener{

    List<FaltaLista> listaFalta = new ArrayList<>();
    FaltaAdapter adapterfaltas;
    RecyclerView recyclerFaltas;
    RequestQueue requestQueue;
    String urlfaltas;
    TextView dni,cac;
    Intent intent;
    GifImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_faltas);

        dni=findViewById(R.id.falta_dni);
        cac=findViewById(R.id.falta_cac);
        intent = getIntent();
        dni.setText(intent.getStringExtra("datodni"));
        cac.setText(intent.getStringExtra("datocac"));

        back = findViewById(R.id.back);
        back.setOnClickListener(this);


        recyclerFaltas = findViewById(R.id.recyclerFaltas);
        recyclerFaltas.setLayoutManager(new LinearLayoutManager(this));
        recyclerFaltas.setHasFixedSize(true);

        urlfaltas = "https://ctarequipa.net/bd_op/cond_pedido_faltas.php?dni="+dni.getText()+"";
        RecyclerFaltas();
    }


    private void RecyclerFaltas() {
        listaFalta.clear();
        requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlfaltas, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        listaFalta.add(new FaltaLista(
                                jsonObject.getString("falta_fecha"),
                                jsonObject.getString("falta_tipo_pa"),
                                jsonObject.getString("falta_nivelfalta"),
                                jsonObject.getString("falta_ocurrencia"),
                                jsonObject.getString("falta_estado")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterfaltas = new FaltaAdapter(getApplicationContext(), listaFalta);
                recyclerFaltas.setAdapter(adapterfaltas);
                adapterfaltas.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(FALTAS.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


    @Override
    public void onClick(View view) {
        view = back;
        intent = new Intent(this, MENU.class);
        intent.putExtra("datodni",dni.getText().toString());
        intent.putExtra("datocac",cac.getText().toString());
        startActivity(intent);
    }
}