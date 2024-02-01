package com.cta.conductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class INICIO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        int Tiempo=4000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(INICIO.this, LOGIN.class));
                finish();
            }
        }, Tiempo);
        //172.25.3.171
        //ctarequipa.net/bd_op/

    }
}


