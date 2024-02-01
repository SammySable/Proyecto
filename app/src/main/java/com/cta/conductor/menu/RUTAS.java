package com.cta.conductor.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.cta.conductor.MENU;
import com.cta.conductor.R;
import com.cta.conductor.menu.rutasguias.ruta301;
import com.cta.conductor.menu.rutasguias.ruta303;
import com.cta.conductor.menu.rutasguias.ruta305;
import com.cta.conductor.menu.rutasguias.ruta336;
import com.cta.conductor.menu.rutasguias.ruta370;
import com.cta.conductor.menu.rutasguias.ruta371;
import com.github.chrisbanes.photoview.PhotoView;

import pl.droidsonroids.gif.GifImageView;


public class RUTAS extends AppCompatActivity implements View.OnClickListener{

    Button button301,button303,button305,button336,button370,button371;

    TextView dni, cac;
    GifImageView back;
    Intent intent;

    PhotoView photoViewA0, photoViewA1, photoViewA2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_rutas);

        //Union de Cards con variable
        button301= findViewById(R.id.button301);
        button303= findViewById(R.id.button303);
        button305= findViewById(R.id.button305);
        button336= findViewById(R.id.button336);
        button370= findViewById(R.id.button370);
        button371= findViewById(R.id.button371);

        button301.setOnClickListener(this);
        button303.setOnClickListener(this);
        button305.setOnClickListener(this);
        button336.setOnClickListener(this);
        button370.setOnClickListener(this);
        button371.setOnClickListener(this);

        intent = getIntent();
        dni=findViewById(R.id.falta_dni);
        cac=findViewById(R.id.falta_cac);
        dni.setText(intent.getStringExtra("datodni"));
        cac.setText(intent.getStringExtra("datocac"));
        back = findViewById(R.id.back);
        back.setOnClickListener(this);


        photoViewA0 = findViewById(R.id.photoViewAnuncio0);
        photoViewA1 = findViewById(R.id.photoViewAnuncio1);
        photoViewA2 = findViewById(R.id.photoViewAnuncio2);

        String urlImagen0 = "https://ctarequipa.net/Anuncio/anuncio0.jfif";

        Glide.with(this)
                .load(urlImagen0)
                .into(photoViewA0);

        String urlImagen1 = "https://ctarequipa.net/Anuncio/anuncio1.png";
        Glide.with(this)
                .load(urlImagen1)
                .into(photoViewA1);

        String urlImagen2 = "https://ctarequipa.net/Anuncio/anuncio2.jpg";
        Glide.with(this)
                .load(urlImagen2)
                .into(photoViewA2);

    }


    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.button301:
                intent = new Intent(this, ruta301.class);
                startActivity(intent);
                break;
            case R.id.button303:
                intent = new Intent(this, ruta303.class);
                startActivity(intent);
                break;
            case R.id.button305:
                intent = new Intent(this, ruta305.class);
                startActivity(intent);
                break;
            case R.id.button336:
                intent = new Intent(this, ruta336.class);
                startActivity(intent);
                break;
            case R.id.button370:
                intent = new Intent(this, ruta370.class);
                startActivity(intent);
                break;
            case R.id.button371:
                intent = new Intent(this, ruta371.class);
                startActivity(intent);
                break;
            case R.id.back:
                //intent = new Intent(this, ERROR.class);
                intent = new Intent(this, MENU.class);
                intent.putExtra("datodni",dni.getText().toString());
                intent.putExtra("datocac",cac.getText().toString());
                startActivity(intent);
                break;

            default:break;
        }
    }

}


