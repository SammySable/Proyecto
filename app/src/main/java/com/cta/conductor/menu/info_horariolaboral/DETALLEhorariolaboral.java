package com.cta.conductor.menu.info_horariolaboral;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.cta.conductor.R;
import com.cta.conductor.menu.info_horariolaboral.info_detallehorario.DetalleAdapter;
import com.cta.conductor.menu.info_horariolaboral.info_detallehorario.DetalleModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DETALLEhorariolaboral extends AppCompatActivity {

    List<DetalleModel> postListDetalle=new ArrayList<>();
    RecyclerView recyclerViewdetalle;
    String urldetallehorario;
    DetalleAdapter adapterdetalle;
    String servicio,fecha,tipo_dia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_horariolaboral);

        recyclerViewdetalle=findViewById(R.id.rv_detallehorario);
        recyclerViewdetalle.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewdetalle.setHasFixedSize(true);

        servicio=getIntent().getStringExtra("dato_servicio");
        tipo_dia=getIntent().getStringExtra("dato_tipo_dia");
        fecha=getIntent().getStringExtra("dato_fecha");

        urldetallehorario="https://ctarequipa.net/bd_op/cond_detallehorario.php?servicio="+servicio+"&tipo_dia="+tipo_dia+"&fecha="+fecha+"";

        //Toast.makeText( DETALLEhorariolaboral.this, tipo_dia,Toast.LENGTH_LONG).show();

        GetDataDetalle();
    }


    private void GetDataDetalle()
    {
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, urldetallehorario, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postListDetalle.add(new DetalleModel(
                                jsonObject.getString("ftime"),
                                jsonObject.getString("fnode"),
                                jsonObject.getString("ttime"),
                                jsonObject.getString("tnode"),
                                jsonObject.getString("servicio")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterdetalle= new DetalleAdapter(getApplicationContext(), postListDetalle);
                recyclerViewdetalle.setAdapter(adapterdetalle);
                adapterdetalle.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}

