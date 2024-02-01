package com.cta.conductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.cta.conductor.menu.FALTAS;
import com.cta.conductor.menu.HORARIOLABORAL;
import com.cta.conductor.menu.PETICION;
import com.cta.conductor.menu.RUTAS;
import com.cta.conductor.menu.VACACIONES;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pl.droidsonroids.gif.GifImageView;

public class MENU extends AppCompatActivity implements View.OnClickListener{

    TextView dni, cac, conductor;
    GifImageView back;
    CardView cv_horariolaboral,cv_reprogramacion,cv_programacionvacaciones,cv_rutas, cv_alertafalta;
    RequestQueue requestQueue;
    ImageView imagenconductor;
    TextView textofaltas;
    int numerosfaltas=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_menu);

        imagenconductor=findViewById(R.id.imageView2);

        //Union y Recojo dato ID
        dni= findViewById(R.id.tiet_numerodni);
        cac= findViewById(R.id.tiet_numerocac);
        conductor= findViewById(R.id.tiet_conductor);

        textofaltas= findViewById(R.id.textofaltas);

        Intent intent=getIntent();
        dni.setText(intent.getStringExtra("datodni"));
        cac.setText(intent.getStringExtra("datocac"));

        //Union de Cards con variable
        cv_horariolaboral=(CardView) findViewById(R.id.cv_horariolaboral);
        cv_reprogramacion=(CardView) findViewById(R.id.cv_reprogramacion);
        cv_programacionvacaciones=(CardView) findViewById(R.id.cv_programarvacaciones);
        cv_rutas=(CardView) findViewById(R.id.cv_rutas);
        cv_alertafalta=(CardView) findViewById(R.id.cv_alertafalta);
        back = findViewById(R.id.back);

        cv_horariolaboral.setOnClickListener(this);
        cv_reprogramacion.setOnClickListener(this);
        cv_programacionvacaciones.setOnClickListener(this);
        cv_rutas.setOnClickListener(this);
        cv_alertafalta.setOnClickListener(this);
        back.setOnClickListener(this);


        buscarNombre("https://ctarequipa.net/bd_op/cond_buscarmenu.php?dni="+dni.getText()+"");
        cantidadFaltas();

    }


    private void buscarNombre(String urlnombre){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(urlnombre, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        conductor.setText(jsonObject.getString("conductor"));
                        //ingreso.setText(jsonObject.getString("fec_ingreso"));

                        Picasso.get()
                                .load("https://ctarequipa.net/bd_op/CONDUCTORES_FOTOS/"+dni.getText()+".jpg")
                                .into(imagenconductor);
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error de Conexión",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }




    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.cv_horariolaboral:
                intent = new Intent(this, HORARIOLABORAL.class);
                intent.putExtra("datodni",dni.getText().toString());
                intent.putExtra("datocac",cac.getText().toString());
                startActivity(intent);
                break;
            case R.id.cv_reprogramacion:
                intent = new Intent(this, PETICION.class);
                intent.putExtra("datodni",dni.getText().toString());
                intent.putExtra("datocac",cac.getText().toString());
                startActivity(intent);
                break;
            case R.id.cv_programarvacaciones:
                //intent = new Intent(this, ERROR.class);
                intent = new Intent(this, VACACIONES.class);
                intent.putExtra("datodni",dni.getText().toString());
                intent.putExtra("datocac",cac.getText().toString());
                startActivity(intent);
                break;
            case R.id.cv_rutas:
                //intent = new Intent(this, ERROR.class);
                intent = new Intent(this, RUTAS.class);
                intent.putExtra("datodni",dni.getText().toString());
                intent.putExtra("datocac",cac.getText().toString());
                startActivity(intent);
                break;
            case R.id.cv_alertafalta:
                //intent = new Intent(this, ERROR.class);
                intent = new Intent(this, FALTAS.class);
                intent.putExtra("datodni",dni.getText().toString());
                intent.putExtra("datocac",cac.getText().toString());
                startActivity(intent);
                break;
            case R.id.back:
                //intent = new Intent(this, ERROR.class);
                intent = new Intent(this, LOGIN.class);
                startActivity(intent);
                break;

            default:break;
        }
    }

    private void cantidadFaltas() {
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest("https://ctarequipa.net/bd_op/cond_pedido_numerofaltas.php?dni="+dni.getText()+"", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        numerosfaltas=jsonObject.getInt("numerosfaltas");
                        //Toast.makeText(getApplicationContext(), numerosfaltas, Toast.LENGTH_LONG).show();

                        if (0 != numerosfaltas){

                            textofaltas.setTextColor(Color.RED);
                            textofaltas.setText("Usted tiene "+numerosfaltas+" reportes acumulados");
                        }

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(),"Error de Conexión",Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

}