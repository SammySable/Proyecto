package com.cta.conductor.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cta.conductor.MENU;
import com.cta.conductor.R;

import com.cta.conductor.menu.info_sugerencia.info_vacaciones.VacacionesAdapter;
import com.cta.conductor.menu.info_sugerencia.info_vacaciones.VacacionesModel;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.droidsonroids.gif.GifImageView;


public class VACACIONES extends AppCompatActivity implements View.OnClickListener {

    private int calendariodia, calendariomes, calendarioaño;
    TextView fecha, dni, cac, diasacumulados, vacacionesdelperiodo;
    GifImageView calendarioinicio, calendariofin, back;
    TextInputEditText vacaFechaInicio, vacaFechaFin;
    List<VacacionesModel> vacaList = new ArrayList<>();
    RequestQueue requestQueue;
    String urlvacaciones,urlEnvioVacaciones, urldias;
    VacacionesAdapter adapter;
    RecyclerView vacaRecycler;
    Intent intent;
    Button buttonEnviar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_vacaciones);

        back = findViewById(R.id.back);
        back.setOnClickListener(this);

        dni = findViewById(R.id.dni);
        cac = findViewById(R.id.cac);
        fecha = findViewById(R.id.fecha);

        //Union y Recojo dato ID
        Intent intent = getIntent();
        dni.setText(intent.getStringExtra("datodni"));
        cac.setText(intent.getStringExtra("datocac"));
        //Toast.makeText(VACACIONES.this, dni.getText(), Toast.LENGTH_SHORT).show();

        calendarioinicio = findViewById(R.id.calendarioinicio);
        calendariofin = findViewById(R.id.calendariofin);
        vacaFechaInicio = findViewById(R.id.vacaFechaInicio);
        vacaFechaFin = findViewById(R.id.vacaFechaFin);
        diasacumulados = findViewById(R.id.diasacumulados);
        vacacionesdelperiodo = findViewById(R.id.vacacionesdelperiodo);
        vacaRecycler = findViewById(R.id.vacaRecycler);
        buttonEnviar = findViewById(R.id.buttonEnviar);

        urlEnvioVacaciones="https://ctarequipa.net/bd_op/cond_envio_vacaciones.php";
        urlvacaciones = "https://ctarequipa.net/bd_op/cond_pedido_vacaciones.php?dni=" + dni.getText().toString() + "";
        urldias = "https://ctarequipa.net/bd_op/cond_pedido_vacacion.php?dni=" + dni.getText().toString() + "";

        fecha = findViewById(R.id.fecha);
        Calendar calendar = Calendar.getInstance();
        int nD = -1;
        nD = calendar.get(Calendar.DAY_OF_WEEK);
        String nom = "";
        switch (nD) {
            case 1:
                nom = "Domingo";
                break;
            case 2:
                nom = "Lunes";
                break;
            case 3:
                nom = "Martes";
                break;
            case 4:
                nom = "Miercoles";
                break;
            case 5:
                nom = "Jueves";
                break;
            case 6:
                nom = "Viernes";
                break;
            case 7:
                nom = "Sabado";
                break;
        }
        int dia = calendar.get(Calendar.DATE);
        int mes = calendar.get(Calendar.MONTH)+1;
        int año = calendar.get(Calendar.YEAR);
        fecha.setText(nom + "  " + dia + "-" + mes + "-" + año);

        calendarioinicio.setOnClickListener(this);
        calendariofin.setOnClickListener(this);
        buttonEnviar.setOnClickListener(this);

        RecyclerVacaciones();
        vacaciones();

    }


    @Override
    public void onClick(View v) {
        if (v == back) {
            intent = new Intent(this, MENU.class);
            intent.putExtra("datodni",dni.getText().toString());
            intent.putExtra("datocac",cac.getText().toString());
            startActivity(intent);
        }

        if (v == calendarioinicio) {
            final Calendar c = Calendar.getInstance();
            calendariodia = c.get(Calendar.DAY_OF_MONTH);
            calendariomes = c.get(Calendar.MONTH);
            calendarioaño = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    vacaFechaInicio.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                }
            }, calendarioaño, calendariomes, calendariodia);
            datePickerDialog.show();
        }

        if (v == calendariofin) {
            final Calendar c = Calendar.getInstance();
            calendariodia = c.get(Calendar.DAY_OF_MONTH);
            calendariomes = c.get(Calendar.MONTH);
            calendarioaño = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    vacaFechaFin.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                }
            }, calendarioaño, calendariomes, calendariodia);
            datePickerDialog.show();
        }

        if (v == buttonEnviar) {
            StringRequest stringRequest=new StringRequest(Request.Method.POST, urlEnvioVacaciones, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), "Envio de Solicitud Correcto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MENU.class);
                    intent.putExtra("datodni", dni.getText().toString());
                    intent.putExtra("datocac", cac.getText().toString());
                    startActivity(intent);
                }
            },new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    //Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String>parametros=new HashMap<String,String>();
                    parametros.put("dni",dni.getText().toString().trim());
                    parametros.put("fecha_inicial",vacaFechaInicio.getText().toString().trim());
                    parametros.put("fecha_final",vacaFechaFin.getText().toString().trim());

                    return parametros;

                }
            };requestQueue=Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
    }


    private void RecyclerVacaciones() {
        vacaList.clear();
        requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlvacaciones, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        vacaList.add(new VacacionesModel(
                                jsonObject.getString("fecha_solicitud"),
                                jsonObject.getString("tipovacaciones"),
                                jsonObject.getString("fecha_inicial"),
                                jsonObject.getString("fecha_final"),
                                jsonObject.getString("numero_dias"),
                                jsonObject.getString("estadosolicitud")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter = new VacacionesAdapter(getApplicationContext(), vacaList);
                vacaRecycler.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(VACACIONES.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


    private void vacaciones(){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(urldias, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        diasacumulados.setText(jsonObject.getString("diasacumulados"));
                        vacacionesdelperiodo.setText(jsonObject.getString("vacacionesdelperiodo"));
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

}

