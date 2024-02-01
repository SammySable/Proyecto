package com.cta.conductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LOGIN extends AppCompatActivity {

    EditText dni, cac;
    Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_login);

        dni = findViewById(R.id.tiet_dni);
        cac = findViewById(R.id.tiet_cac);
        btnlogin = findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarUsuario("https://ctarequipa.net/bd_op/cond_login.php");

            }
        });recuperarPreferencias();
    }


    private void validarUsuario(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()) {
                    if (!response.equalsIgnoreCase(" ")) {
                        guardarPreferencias();
                        Intent intent = new Intent(getApplicationContext(), MENU.class);
                        intent.putExtra("datodni", dni.getText().toString());
                        intent.putExtra("datocac", cac.getText().toString());
                        startActivity(intent);
                    }

                else if (dni.getText().toString().equals("")) {
                        Toast.makeText( LOGIN.this, "Ingrese DNI",
                                Toast.LENGTH_LONG).show();
                    } else if (cac.getText().toString().equals("")) {
                        Toast.makeText(LOGIN.this, "Ingrese CAC",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LOGIN.this, "DNI o CAC equivocado",
                                Toast.LENGTH_SHORT).show();
                    }
                } else if (dni.getText().toString().equals("")) {
                    Toast.makeText( LOGIN.this, "Ingrese DNI",
                            Toast.LENGTH_LONG).show();
                } else if (cac.getText().toString().equals("")) {
                    Toast.makeText(LOGIN.this, "Ingrese CAC",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LOGIN.this, "Error de conexión",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LOGIN.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("dni", dni.getText().toString().trim());
                parametros.put("cac", cac.getText().toString().trim());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }




    private void guardarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("edtDNI",dni.getText().toString().trim());
        editor.putString("edtCAC",cac.getText().toString().trim());
        editor.putBoolean("sesion",true);
        editor.commit();
    }

    private void recuperarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        dni.setText(preferences.getString("edtDNI",""));
        cac.setText(preferences.getString("edtCAC",""));
    }
}