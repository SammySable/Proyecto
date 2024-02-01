package com.cta.conductor.menu.info_horariolaboral;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class HORAhorariolaboral extends AppCompatActivity{

    String urldetallehora;
    String id;
    RequestQueue requestQueue;
    TextView horainicio1,horainicio2,horainicio3,horainicio4,
                horafinal1,horafinal2,horafinal3,horafinal4,
                recorido1,recorido2,recorido3,recorido4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_horalaboral);

        horainicio1=findViewById(R.id.horainicio1);
        horainicio2=findViewById(R.id.horainicio2);
        horainicio3=findViewById(R.id.horainicio3);
        horainicio4=findViewById(R.id.horainicio4);
        horafinal1=findViewById(R.id.horafinal1);
        horafinal2=findViewById(R.id.horafinal2);
        horafinal3=findViewById(R.id.horafinal3);
        horafinal4=findViewById(R.id.horafinal4);
        recorido1=findViewById(R.id.recorido1);
        recorido2=findViewById(R.id.recorido2);
        recorido3=findViewById(R.id.recorido3);
        recorido4=findViewById(R.id.recorido4);


        id=getIntent().getStringExtra("hora_id");


        urldetallehora="https://ctarequipa.net/bd_op/cond_detallehora.php?id="+id+"";

        //Toast.makeText( HORAhorariolaboral.this, tipo_dia,Toast.LENGTH_LONG).show();

        DatosHora();
    }


    private void DatosHora()
    {
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(urldetallehora, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        horainicio1.setText(jsonObject.getString("horainicio1"));
                        horainicio2.setText(jsonObject.getString("horainicio2"));
                        horainicio3.setText(jsonObject.getString("horainicio3"));
                        horainicio4.setText(jsonObject.getString("horainicio4"));
                        horafinal1.setText(jsonObject.getString("horafinal1"));
                        horafinal2.setText(jsonObject.getString("horafinal2"));
                        horafinal3.setText(jsonObject.getString("horafinal3"));
                        horafinal4.setText(jsonObject.getString("horafinal4"));
                        recorido1.setText(jsonObject.getString("recorido1"));
                        recorido2.setText(jsonObject.getString("recorido2"));
                        recorido3.setText(jsonObject.getString("recorido3"));
                        recorido4.setText(jsonObject.getString("recorido4"));


                    } catch (JSONException e) {
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}

