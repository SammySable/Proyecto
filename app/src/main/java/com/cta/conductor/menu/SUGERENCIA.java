package com.cta.conductor.menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.cta.conductor.R;
import com.cta.conductor.menu.info_sugerencia.SugeAdapter;
import com.cta.conductor.menu.info_sugerencia.SugeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;

import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import java.util.Map;
import android.provider.MediaStore;
import android.util.Base64;
import android.net.Uri;

public class SUGERENCIA extends AppCompatActivity {

    TextView fecha,dni,cac;
    ArrayList<String> arrayList_tiposugerencia;
    ArrayAdapter<String> arrayAdapter_tiposugerencia;
    ArrayList<String> arrayList_area1;
    ArrayList<String> arrayList_area2;
    ArrayList<String> arrayList_area3;
    ArrayList<String> arrayList_area4;
    ArrayList<String> arrayList_area5;
    ArrayList<String> arrayList_area6;
    ArrayList<String> arrayList_area0;
    ArrayAdapter<String> arrayAdapter_area;
    List<SugeModel> sugeList=new ArrayList<>();
    String urlsuge;
    RequestQueue requestQueue;
    RecyclerView sugeRecycler;
    Spinner sugeTipo, sugeArea;
    Button bt_seleccionar, bt_enviar;
    ImageView sugeArchivo;
    EditText sugeInforme;
    SugeAdapter adaptersuge;
    Bitmap bitmap;
    int PICK_IMAGE_REQUEST = 1;
    String UPLOAD_URL = "https://ctarequipa.net/bd_op/cond_envio_sugerencia.php";




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sugerencia);

        sugeTipo = findViewById(R.id.sugeTipo);
        sugeArea = findViewById(R.id.sugeArea);
        bt_seleccionar = findViewById(R.id.bt_selecionar);
        bt_enviar = findViewById(R.id.bt_enviar);
        sugeArchivo = findViewById(R.id.sugeArchivo);
        sugeInforme = findViewById(R.id.sugeInforme);
        // vinculando la casilla en la que ira lo que sera la imagen con la variable que obtendras luego
        // no confundas las cosas, el ImageView es la caja de la imagen, tu creas la variable sugeArchivo (en este caso) y le pones queview
        // luego ese sugeArchivo lo iguala a la caja creada xml,
        //y ese que?
        dni = findViewById(R.id.sug_dni);
        cac = findViewById(R.id.sug_cac);
        fecha = findViewById(R.id.tv_fecha);
        sugeRecycler =findViewById(R.id.sugeRecycler);
        sugeRecycler.setLayoutManager(new LinearLayoutManager(this));
        sugeRecycler.setHasFixedSize(true);

        //Union y Recojo dato ID
        Intent intent = getIntent();
        dni.setText(intent.getStringExtra("datodni"));
        cac.setText(intent.getStringExtra("datocac"));
        //Toast.makeText(SUGERENCIA.this, dni.getText(), Toast.LENGTH_SHORT).show();

        urlsuge = "https://ctarequipa.net/bd_op/cond_pedido_sugerencia.php?dni="+dni.getText().toString()+"";
        GetDataSugerencia();


        bt_seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });

        bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });

        arrayList_tiposugerencia = new ArrayList<>();
        arrayList_tiposugerencia.add("Seleccione");
        arrayList_tiposugerencia.add("ACTUALIZACION DE DIRECCION");
        arrayList_tiposugerencia.add("BOLETAS");
        arrayList_tiposugerencia.add("DESCUENTO GRATIFICACION");
        arrayList_tiposugerencia.add("DESCUENTO POR PLANILLA");
        arrayList_tiposugerencia.add("DNI ACTUALIZADO");
        arrayList_tiposugerencia.add("HORAS EXTRAS");
        arrayList_tiposugerencia.add("PAGO DE BONO DE ASISTENCIA");
        arrayList_tiposugerencia.add("PAGO DE BONO DE PRODUCCION");
        arrayList_tiposugerencia.add("PAGO DE FERIADO");
        arrayList_tiposugerencia.add("PAGO INCORRECTO");
        arrayList_tiposugerencia.add("DUPLICADO DE CAC");
        arrayList_tiposugerencia.add("HORARIOS");
        arrayList_tiposugerencia.add("PARADEROS");
        arrayList_tiposugerencia.add("PETICION DE ACLARACIONES");
        arrayList_tiposugerencia.add("PROBLEMA EN VIA");
        arrayList_tiposugerencia.add("PROGRAMACION VACACIONES");
        arrayList_tiposugerencia.add("TURNOS");
        arrayList_tiposugerencia.add("EVACIONES DE PARADEROS");
        arrayList_tiposugerencia.add("VIDEOS DE RECAUDO");
        arrayList_tiposugerencia.add("PATIO 1");
        arrayList_tiposugerencia.add("PATIO 2");
        arrayList_tiposugerencia.add("BUSES");
        arrayList_tiposugerencia.add("A PERSONAL DE CTA");
        arrayList_tiposugerencia.add("OTROS");

        arrayAdapter_tiposugerencia = new ArrayAdapter<>(getApplicationContext(),
                R.layout.item_color, arrayList_tiposugerencia);

        sugeTipo.setAdapter(arrayAdapter_tiposugerencia);

        arrayList_area0 = new ArrayList<>();
        arrayList_area0.add("Seleccione Sugerencia");

        arrayList_area1 = new ArrayList<>();
        arrayList_area1.add("TALENTO HUMANO");

        arrayList_area2 = new ArrayList<>();
        arrayList_area2.add("OPERACIONES");

        arrayList_area3 = new ArrayList<>();
        arrayList_area3.add("RECAUDO");

        arrayList_area4 = new ArrayList<>();
        arrayList_area4.add("ADMINISTRACION");

        arrayList_area5 = new ArrayList<>();
        arrayList_area5.add("TALLER");

        arrayList_area6 = new ArrayList<>();
        arrayList_area6.add("Seleccione");
        arrayList_area6.add("TALENTO HUMANO");
        arrayList_area6.add("OPERACIONES");
        arrayList_area6.add("RECAUDO");
        arrayList_area6.add("ADMINISTRACION");
        arrayList_area6.add("TALLER");


        sugeTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    arrayAdapter_area = new ArrayAdapter<>(getApplicationContext(),
                            R.layout.item_color, arrayList_area0);
                }

                if (position == 1 || position == 2 || position == 3 || position == 4 || position == 5 ||
                        position == 6 || position == 7 || position == 8 || position == 9 || position == 10) {
                    arrayAdapter_area = new ArrayAdapter<>(getApplicationContext(),
                            R.layout.item_color, arrayList_area1);
                }

                if (position == 11 || position == 12 || position == 13 || position == 14 ||
                        position == 15 || position == 16 || position == 17) {
                    arrayAdapter_area = new ArrayAdapter<>(getApplicationContext(),
                            R.layout.item_color, arrayList_area2);
                }

                if (position == 18 || position == 19) {
                    arrayAdapter_area = new ArrayAdapter<>(getApplicationContext(),
                            R.layout.item_color, arrayList_area3);
                }

                if (position == 20 || position == 21) {
                    arrayAdapter_area = new ArrayAdapter<>(getApplicationContext(),
                            R.layout.item_color, arrayList_area4);
                }

                if (position == 22) {
                    arrayAdapter_area = new ArrayAdapter<>(getApplicationContext(),
                            R.layout.item_color, arrayList_area5);
                }

                if (position == 23 || position == 24) {
                    arrayAdapter_area = new ArrayAdapter<>(getApplicationContext(),
                            R.layout.item_color, arrayList_area6);
                }


                sugeArea.setAdapter(arrayAdapter_area);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



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
        int mes = calendar.get(Calendar.MONTH);
        int año = calendar.get(Calendar.YEAR);
        fecha.setText(nom + "  " + dia + "-" + mes + "-" + año);

    }

    //Subir imagen
    public String getStringImagen(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public void uploadImage() {
        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo...", "Espere por favor");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        //Toast.makeText(SUGERENCIA.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                //Toast.makeText(SUGERENCIA.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String tiposugerencia = sugeTipo.getSelectedItem().toString().trim();
                String area = sugeArea.getSelectedItem().toString().trim();
                String archivo = getStringImagen(bitmap);
                String informesugerencia = sugeInforme.getText().toString().trim();

                Map<String, String> params = new Hashtable<String, String>();
                params.put("dni",dni.getText().toString());
                params.put("tiposugerencia", tiposugerencia);
                params.put("area", area);
                params.put("archivo", archivo);
                params.put("informesugerencia", informesugerencia);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Seleciona imagen"), PICK_IMAGE_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Cómo obtener el mapa de bits de la Galería
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Configuración del mapa de bits en ImageView
                sugeArchivo.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void GetDataSugerencia()
    {
        sugeList.clear();
        requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, urlsuge, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        sugeList.add(new SugeModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("tipo"),
                                jsonObject.getString("area"),
                                jsonObject.getString("informe"),
                                jsonObject.getString("estado")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adaptersuge=new SugeAdapter(getApplicationContext(),sugeList);
                sugeRecycler.setAdapter(adaptersuge);
                adaptersuge.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(SUGERENCIA.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}




