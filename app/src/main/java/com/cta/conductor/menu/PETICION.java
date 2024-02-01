package com.cta.conductor.menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.cta.conductor.menu.info_peticion.PetiAdapter;
import com.cta.conductor.menu.info_peticion.PetiModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import pl.droidsonroids.gif.GifImageView;

public class PETICION extends AppCompatActivity implements View.OnClickListener{

    TextView fecha,dni,cac;
    RequestQueue requestQueue;
    AutoCompleteTextView petiTipo, petiMotivo;
    PetiAdapter adapterpeti;
    List<PetiModel>petiList=new ArrayList<>();
    RecyclerView petiRecycler;
    String urlpeti;
    Button bt_seleccionar, bt_enviar;
    ImageView petiArchivo;
    EditText petiInforme;
    Bitmap bitmap;
    Intent intent;
    GifImageView back;

    int PICK_IMAGE_REQUEST = 1;
    String UPLOAD_URL = "https://ctarequipa.net/bd_op/cond_envio_peticion.php";
    String URLpeticion = "https://ctarequipa.net/bd_op/cond_envio_peticion.php";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_peticion);

        back = findViewById(R.id.back);
        back.setOnClickListener(this);

        bt_seleccionar = findViewById(R.id.bt_selecionar);
        bt_enviar = findViewById(R.id.bt_enviar);
        dni= findViewById(R.id.dni);
        cac= findViewById(R.id.cac);

        //Union y Recojo dato ID
        Intent intent = getIntent();
        dni.setText(intent.getStringExtra("datodni"));
        cac.setText(intent.getStringExtra("datocac"));

        petiRecycler=findViewById(R.id.peti_recycler);
        petiRecycler.setLayoutManager(new LinearLayoutManager(this));
        petiRecycler.setHasFixedSize(true);

        petiTipo = findViewById(R.id.petitipo);
        petiMotivo = findViewById(R.id.petimotivo);
        petiArchivo = findViewById(R.id.petiArchivo);
        petiInforme = findViewById(R.id.petiInforme);

        urlpeti = "https://ctarequipa.net/bd_op/cond_pedido_peticion.php?dni="+ dni.getText().toString() + "";
        GetDataPeticion();

        bt_seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionararchivo();
            }
        });

        bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            /*
            public void onClick(View v) {
                enviarpeticionimgan();
            }
            */
            public void onClick(View v) {
                enviarpeticion();
            }

        });

        String[] Tipo = {"LICENCIA CON GOCE DE HABER","LICENCIA SIN GOCE DE HABER",
                "CAMBIO DE FRANCO (Ejecución)", "CAMBIO DE SERVICIO ( Ejecución )",
                "AJUSTE DE FRANCO ( 1 Semana Antes )","AJUSTE DE SERVICIO ( 1 Semana Antes )",
                "CAMBIO DE VACACIONES ( Entre 2 Pilotos )", "AJUSTE DE VACACIONES ( 1 Solo Piloto )",
                "SOLICITUD DE TURNO", "DIA FESTIVO", "CAMBIO DE FRANCO ADICIONAL", "OTROS"};
        ArrayAdapter<String> adaptersolicitud = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Tipo);
        petiTipo.setAdapter(adaptersolicitud);

        String[] Motivo = {"CITA EN JUZGADO","CUMPLEAÑOS DEL CONDUCTOR","CITA MEDICA",
                " STUDIOS","EXAMEN DE MANEJO","FAMILIAR","MOTIVO PERSONAL","VIAJE"};
        ArrayAdapter<String> adaptermotivo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Motivo);
        petiMotivo.setAdapter(adaptermotivo);


        fecha=findViewById(R.id.fecha);
        Calendar calendar = Calendar.getInstance();
        int nD =-1;
        nD=calendar.get(Calendar.DAY_OF_WEEK);
        String nom="";
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
        int dia=calendar.get(Calendar.DATE);
        int mes=calendar.get(Calendar.MONTH)+1;
        int año=calendar.get(Calendar.YEAR);
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



    public void enviarpeticionimagen() {
        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo...", "Espere por favor");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        Toast.makeText(getApplicationContext(), "Envio de Solicitud Correcto", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MENU.class);
                        intent.putExtra("datodni", dni.getText().toString());
                        intent.putExtra("datocac", cac.getText().toString());
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(), "Error de Envio de Solicitud", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MENU.class);
                intent.putExtra("datodni", dni.getText().toString());
                intent.putExtra("datocac", cac.getText().toString());
                startActivity(intent);
                Toast.makeText(PETICION.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String tipopeticion = petiTipo.getText().toString().trim();
                String motivo = petiMotivo.getText().toString().trim();
                String archivo = getStringImagen(bitmap);
                String informepeticion = petiInforme.getText().toString().trim();

                Map<String, String> params = new Hashtable<String, String>();
                params.put("dni",dni.getText().toString());
                params.put("tipopeticion", tipopeticion);
                params.put("motivo", motivo);
                params.put("archivo", archivo);
                params.put("informepeticion", informepeticion);

                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    public void enviarpeticion() {
        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo...", "Espere por favor");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLpeticion,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        Toast.makeText(getApplicationContext(), "Envio de Solicitud Correcto", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MENU.class);
                        intent.putExtra("datodni", dni.getText().toString());
                        intent.putExtra("datocac", cac.getText().toString());
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(), "Error de Envio de Solicitud", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MENU.class);
                intent.putExtra("datodni", dni.getText().toString());
                intent.putExtra("datocac", cac.getText().toString());
                startActivity(intent);
                Toast.makeText(PETICION.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String tipopeticion = petiTipo.getText().toString().trim();
                String motivo = petiMotivo.getText().toString().trim();
                //String archivo = getStringImagen(bitmap);
                String informepeticion = petiInforme.getText().toString().trim();

                Map<String, String> params = new Hashtable<String, String>();
                params.put("dni",dni.getText().toString());
                params.put("tipopeticion", tipopeticion);
                params.put("motivo", motivo);
                //params.put("archivo", archivo);
                params.put("informepeticion", informepeticion);

                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    private void seleccionararchivo() {
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
                petiArchivo.setImageBitmap(bitmap);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void GetDataPeticion()
    {
        petiList.clear();

        requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, urlpeti, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Toast.makeText(PETICION.this,response.toString(),Toast.LENGTH_LONG).show();
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        petiList.add(new PetiModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("tipo"),
                                jsonObject.getString("motivo"),
                                jsonObject.getString("informe"),
                                jsonObject.getString("estadosolicitud"),
                                jsonObject.getString("comentario")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterpeti=new PetiAdapter(getApplicationContext(),petiList);
                petiRecycler.setAdapter(adapterpeti);
                adapterpeti.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PETICION.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue= Volley.newRequestQueue(this);
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




