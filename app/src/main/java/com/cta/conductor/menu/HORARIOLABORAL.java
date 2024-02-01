package com.cta.conductor.menu;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonArrayRequest;
import com.cta.conductor.R;
import com.cta.conductor.menu.info_horariolaboral.DETALLEhorariolaboral;
import com.cta.conductor.menu.info_horariolaboral.HORAhorariolaboral;
import com.cta.conductor.menu.info_horariolaboral.info_horas.HoraAdapter;
import com.cta.conductor.menu.info_horariolaboral.info_horas.HoraModel;
import com.cta.conductor.menu.info_horariolaboral.PostAdapter;
import com.cta.conductor.menu.info_horariolaboral.PostAdapterFranco;
import com.cta.conductor.menu.info_horariolaboral.PostModel;
import com.cta.conductor.menu.info_horariolaboral.PostModelFranco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;


public class HORARIOLABORAL extends AppCompatActivity implements SearchView.OnQueryTextListener
{

    String dni;
    HoraAdapter adapterhora;
    PostAdapter adapter;
    PostAdapterFranco adapterFranco;
    String id_recycler, id;
    String dato_servicio, dato_fecha, dato_tipo_dia;
    int day;
    List<PostModelFranco>franco=new ArrayList<>();

    List<PostModel>postList=new ArrayList<>();


    List<PostModel>postList1lunes1=new ArrayList<>();
    List<PostModel>postList1lunes2=new ArrayList<>();
    List<PostModel>postList1lunes3=new ArrayList<>();
    List<PostModel>postList1lunes4=new ArrayList<>();
    List<PostModel>postList1lunes5=new ArrayList<>();
    List<PostModel>postList1lunes6=new ArrayList<>();
    List<PostModel>postList1martes1=new ArrayList<>();
    List<PostModel>postList1martes2=new ArrayList<>();
    List<PostModel>postList1martes3=new ArrayList<>();
    List<PostModel>postList1martes4=new ArrayList<>();
    List<PostModel>postList1martes5=new ArrayList<>();
    List<PostModel>postList1martes6=new ArrayList<>();
    List<PostModel>postList1miercoles1=new ArrayList<>();
    List<PostModel>postList1miercoles2=new ArrayList<>();
    List<PostModel>postList1miercoles3=new ArrayList<>();
    List<PostModel>postList1miercoles4=new ArrayList<>();
    List<PostModel>postList1miercoles5=new ArrayList<>();
    List<PostModel>postList1miercoles6=new ArrayList<>();
    List<PostModel>postList1jueves1=new ArrayList<>();
    List<PostModel>postList1jueves2=new ArrayList<>();
    List<PostModel>postList1jueves3=new ArrayList<>();
    List<PostModel>postList1jueves4=new ArrayList<>();
    List<PostModel>postList1jueves5=new ArrayList<>();
    List<PostModel>postList1jueves6=new ArrayList<>();
    List<PostModel>postList1viernes1=new ArrayList<>();
    List<PostModel>postList1viernes2=new ArrayList<>();
    List<PostModel>postList1viernes3=new ArrayList<>();
    List<PostModel>postList1viernes4=new ArrayList<>();
    List<PostModel>postList1viernes5=new ArrayList<>();
    List<PostModel>postList1viernes6=new ArrayList<>();
    List<PostModel>postList1sabado1=new ArrayList<>();
    List<PostModel>postList1sabado2=new ArrayList<>();
    List<PostModel>postList1sabado3=new ArrayList<>();
    List<PostModel>postList1sabado4=new ArrayList<>();
    List<PostModel>postList1sabado5=new ArrayList<>();
    List<PostModel>postList1sabado6=new ArrayList<>();
    List<PostModel>postList1domingo1=new ArrayList<>();
    List<PostModel>postList1domingo2=new ArrayList<>();
    List<PostModel>postList1domingo3=new ArrayList<>();
    List<PostModel>postList1domingo4=new ArrayList<>();
    List<PostModel>postList1domingo5=new ArrayList<>();
    List<PostModel>postList1domingo6=new ArrayList<>();

    List<PostModel>postList2lunes1=new ArrayList<>();
    List<PostModel>postList2lunes2=new ArrayList<>();
    List<PostModel>postList2lunes3=new ArrayList<>();
    List<PostModel>postList2lunes4=new ArrayList<>();
    List<PostModel>postList2lunes5=new ArrayList<>();
    List<PostModel>postList2lunes6=new ArrayList<>();
    List<PostModel>postList2martes1=new ArrayList<>();
    List<PostModel>postList2martes2=new ArrayList<>();
    List<PostModel>postList2martes3=new ArrayList<>();
    List<PostModel>postList2martes4=new ArrayList<>();
    List<PostModel>postList2martes5=new ArrayList<>();
    List<PostModel>postList2martes6=new ArrayList<>();
    List<PostModel>postList2miercoles1=new ArrayList<>();
    List<PostModel>postList2miercoles2=new ArrayList<>();
    List<PostModel>postList2miercoles3=new ArrayList<>();
    List<PostModel>postList2miercoles4=new ArrayList<>();
    List<PostModel>postList2miercoles5=new ArrayList<>();
    List<PostModel>postList2miercoles6=new ArrayList<>();
    List<PostModel>postList2jueves1=new ArrayList<>();
    List<PostModel>postList2jueves2=new ArrayList<>();
    List<PostModel>postList2jueves3=new ArrayList<>();
    List<PostModel>postList2jueves4=new ArrayList<>();
    List<PostModel>postList2jueves5=new ArrayList<>();
    List<PostModel>postList2jueves6=new ArrayList<>();
    List<PostModel>postList2viernes1=new ArrayList<>();
    List<PostModel>postList2viernes2=new ArrayList<>();
    List<PostModel>postList2viernes3=new ArrayList<>();
    List<PostModel>postList2viernes4=new ArrayList<>();
    List<PostModel>postList2viernes5=new ArrayList<>();
    List<PostModel>postList2viernes6=new ArrayList<>();
    List<PostModel>postList2sabado1=new ArrayList<>();
    List<PostModel>postList2sabado2=new ArrayList<>();
    List<PostModel>postList2sabado3=new ArrayList<>();
    List<PostModel>postList2sabado4=new ArrayList<>();
    List<PostModel>postList2sabado5=new ArrayList<>();
    List<PostModel>postList2sabado6=new ArrayList<>();
    List<PostModel>postList2domingo1=new ArrayList<>();
    List<PostModel>postList2domingo2=new ArrayList<>();
    List<PostModel>postList2domingo3=new ArrayList<>();
    List<PostModel>postList2domingo4=new ArrayList<>();
    List<PostModel>postList2domingo5=new ArrayList<>();
    List<PostModel>postList2domingo6=new ArrayList<>();

    List<HoraModel> postList3lunes1 =new ArrayList<>();
    List<HoraModel> postList3lunes2 =new ArrayList<>();
    List<HoraModel> postList3lunes3 =new ArrayList<>();
    List<HoraModel> postList3lunes4 =new ArrayList<>();
    List<HoraModel> postList3lunes5 =new ArrayList<>();
    List<HoraModel> postList3lunes6 =new ArrayList<>();
    List<HoraModel> postList3martes1 =new ArrayList<>();
    List<HoraModel> postList3martes2 =new ArrayList<>();
    List<HoraModel> postList3martes3 =new ArrayList<>();
    List<HoraModel> postList3martes4 =new ArrayList<>();
    List<HoraModel> postList3martes5 =new ArrayList<>();
    List<HoraModel> postList3martes6 =new ArrayList<>();
    List<HoraModel> postList3miercoles1 =new ArrayList<>();
    List<HoraModel> postList3miercoles2 =new ArrayList<>();
    List<HoraModel> postList3miercoles3 =new ArrayList<>();
    List<HoraModel> postList3miercoles4 =new ArrayList<>();
    List<HoraModel> postList3miercoles5 =new ArrayList<>();
    List<HoraModel> postList3miercoles6 =new ArrayList<>();
    List<HoraModel> postList3jueves1 =new ArrayList<>();
    List<HoraModel> postList3jueves2 =new ArrayList<>();
    List<HoraModel> postList3jueves3 =new ArrayList<>();
    List<HoraModel> postList3jueves4 =new ArrayList<>();
    List<HoraModel> postList3jueves5 =new ArrayList<>();
    List<HoraModel> postList3jueves6 =new ArrayList<>();
    List<HoraModel> postList3viernes1 =new ArrayList<>();
    List<HoraModel> postList3viernes2 =new ArrayList<>();
    List<HoraModel> postList3viernes3 =new ArrayList<>();
    List<HoraModel> postList3viernes4 =new ArrayList<>();
    List<HoraModel> postList3viernes5 =new ArrayList<>();
    List<HoraModel> postList3viernes6 =new ArrayList<>();
    List<HoraModel> postList3sabado1 =new ArrayList<>();
    List<HoraModel> postList3sabado2 =new ArrayList<>();
    List<HoraModel> postList3sabado3 =new ArrayList<>();
    List<HoraModel> postList3sabado4 =new ArrayList<>();
    List<HoraModel> postList3sabado5 =new ArrayList<>();
    List<HoraModel> postList3sabado6 =new ArrayList<>();
    List<HoraModel> postList3domingo1 =new ArrayList<>();
    List<HoraModel> postList3domingo2 =new ArrayList<>();
    List<HoraModel> postList3domingo3 =new ArrayList<>();
    List<HoraModel> postList3domingo4 =new ArrayList<>();
    List<HoraModel> postList3domingo5 =new ArrayList<>();
    List<HoraModel> postList3domingo6 =new ArrayList<>();
    List<HoraModel> postList3semana1 =new ArrayList<>();
    List<HoraModel> postList3semana2 =new ArrayList<>();
    List<HoraModel> postList3semana3 =new ArrayList<>();
    List<HoraModel> postList3semana4 =new ArrayList<>();
    List<HoraModel> postList3semana5 =new ArrayList<>();
    List<HoraModel> postList3semana6 =new ArrayList<>();


    RecyclerView recyclerView1lunes1,recyclerView1martes1,recyclerView1miercoles1,recyclerView1jueves1,recyclerView1viernes1,recyclerView1sabado1,recyclerView1domingo1,
            recyclerView1lunes2,recyclerView1martes2,recyclerView1miercoles2,recyclerView1jueves2,recyclerView1viernes2,recyclerView1sabado2,recyclerView1domingo2,
            recyclerView1lunes3,recyclerView1martes3,recyclerView1miercoles3,recyclerView1jueves3,recyclerView1viernes3,recyclerView1sabado3,recyclerView1domingo3,
            recyclerView1lunes4,recyclerView1martes4,recyclerView1miercoles4,recyclerView1jueves4,recyclerView1viernes4,recyclerView1sabado4,recyclerView1domingo4,
            recyclerView1lunes5,recyclerView1martes5,recyclerView1miercoles5,recyclerView1jueves5,recyclerView1viernes5,recyclerView1sabado5,recyclerView1domingo5,
            recyclerView1lunes6,recyclerView1martes6,recyclerView1miercoles6,recyclerView1jueves6,recyclerView1viernes6,recyclerView1sabado6,recyclerView1domingo6;

    RecyclerView recyclerView2lunes1,recyclerView2martes1,recyclerView2miercoles1,recyclerView2jueves1,recyclerView2viernes1,recyclerView2sabado1,recyclerView2domingo1,
            recyclerView2lunes2,recyclerView2martes2,recyclerView2miercoles2,recyclerView2jueves2,recyclerView2viernes2,recyclerView2sabado2,recyclerView2domingo2,
            recyclerView2lunes3,recyclerView2martes3,recyclerView2miercoles3,recyclerView2jueves3,recyclerView2viernes3,recyclerView2sabado3,recyclerView2domingo3,
            recyclerView2lunes4,recyclerView2martes4,recyclerView2miercoles4,recyclerView2jueves4,recyclerView2viernes4,recyclerView2sabado4,recyclerView2domingo4,
            recyclerView2lunes5,recyclerView2martes5,recyclerView2miercoles5,recyclerView2jueves5,recyclerView2viernes5,recyclerView2sabado5,recyclerView2domingo5,
            recyclerView2lunes6,recyclerView2martes6,recyclerView2miercoles6,recyclerView2jueves6,recyclerView2viernes6,recyclerView2sabado6,recyclerView2domingo6;


    RecyclerView recyclerView3lunes1, recyclerView3martes1, recyclerView3miercoles1, recyclerView3jueves1, recyclerView3viernes1, recyclerView3sabado1, recyclerView3domingo1,
            recyclerView3lunes2, recyclerView3martes2, recyclerView3miercoles2, recyclerView3jueves2, recyclerView3viernes2, recyclerView3sabado2, recyclerView3domingo2,
            recyclerView3lunes3, recyclerView3martes3, recyclerView3miercoles3, recyclerView3jueves3, recyclerView3viernes3, recyclerView3sabado3, recyclerView3domingo3,
            recyclerView3lunes4, recyclerView3martes4, recyclerView3miercoles4, recyclerView3jueves4, recyclerView3viernes4, recyclerView3sabado4, recyclerView3domingo4,
            recyclerView3lunes5, recyclerView3martes5, recyclerView3miercoles5, recyclerView3jueves5, recyclerView3viernes5, recyclerView3sabado5, recyclerView3domingo5,
            recyclerView3lunes6, recyclerView3martes6, recyclerView3miercoles6, recyclerView3jueves6, recyclerView3viernes6, recyclerView3sabado6, recyclerView3domingo6,
            recyclerView3semana1, recyclerView3semana2, recyclerView3semana3, recyclerView3semana4, recyclerView3semana5, recyclerView3semana6;


    String url1lunes1,url1lunes2,url1lunes3,url1lunes4,url1lunes5,url1lunes6,
            url1martes1,url1martes2,url1martes3,url1martes4,url1martes5,url1martes6,
            url1miercoles1,url1miercoles2,url1miercoles3,url1miercoles4,url1miercoles5,url1miercoles6,
            url1jueves1,url1jueves2,url1jueves3,url1jueves4,url1jueves5,url1jueves6,
            url1viernes1,url1viernes2,url1viernes3,url1viernes4,url1viernes5,url1viernes6,
            url1sabado1,url1sabado2,url1sabado3,url1sabado4,url1sabado5,url1sabado6,
            url1domingo1,url1domingo2,url1domingo3,url1domingo4,url1domingo5,url1domingo6,
            url2lunes1,url2lunes2,url2lunes3,url2lunes4,url2lunes5,url2lunes6,
            url2martes1,url2martes2,url2martes3,url2martes4,url2martes5,url2martes6,
            url2miercoles1,url2miercoles2,url2miercoles3,url2miercoles4,url2miercoles5,url2miercoles6,
            url2jueves1,url2jueves2,url2jueves3,url2jueves4,url2jueves5,url2jueves6,
            url2viernes1,url2viernes2,url2viernes3,url2viernes4,url2viernes5,url2viernes6,
            url2sabado1,url2sabado2,url2sabado3,url2sabado4,url2sabado5,url2sabado6,
            url2domingo1,url2domingo2,url2domingo3,url2domingo4,url2domingo5,url2domingo6,
            url3lunes1,url3lunes2,url3lunes3,url3lunes4,url3lunes5,url3lunes6,
            url3martes1,url3martes2,url3martes3,url3martes4,url3martes5,url3martes6,
            url3miercoles1,url3miercoles2,url3miercoles3,url3miercoles4,url3miercoles5,url3miercoles6,
            url3jueves1,url3jueves2,url3jueves3,url3jueves4,url3jueves5,url3jueves6,
            url3viernes1,url3viernes2,url3viernes3,url3viernes4,url3viernes5,url3viernes6,
            url3sabado1,url3sabado2,url3sabado3,url3sabado4,url3sabado5,url3sabado6,
            url3domingo1,url3domingo2,url3domingo3,url3domingo4,url3domingo5,url3domingo6,
            url3semana1,url3semana2,url3semana3,url3semana4,url3semana5,url3semana6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_horariolaboral);

        //Union y Recojo dato ID
        dni=getIntent().getStringExtra("datodni");

        url1lunes1 = "https://ctarequipa.net/bd_op/cond_horariolunes11.php?dni="+dni+"";
        url1lunes2 = "https://ctarequipa.net/bd_op/cond_horariolunes12.php?dni="+dni+"";
        url1martes1 ="https://ctarequipa.net/bd_op/cond_horariomartes11.php?dni="+dni+"";
        url1martes2 ="https://ctarequipa.net/bd_op/cond_horariomartes12.php?dni="+dni+"";
        url1miercoles1 ="https://ctarequipa.net/bd_op/cond_horariomiercoles11.php?dni="+dni+"";
        url1miercoles2 ="https://ctarequipa.net/bd_op/cond_horariomiercoles12.php?dni="+dni+"";
        url1jueves1 ="https://ctarequipa.net/bd_op/cond_horariojueves11.php?dni="+dni+"";
        url1jueves2 ="https://ctarequipa.net/bd_op/cond_horariojueves12.php?dni="+dni+"";
        url1viernes1 ="https://ctarequipa.net/bd_op/cond_horarioviernes11.php?dni="+dni+"";
        url1viernes2 ="https://ctarequipa.net/bd_op/cond_horarioviernes12.php?dni="+dni+"";
        url1sabado1 ="https://ctarequipa.net/bd_op/cond_horariosabado11.php?dni="+dni+"";
        url1sabado2 ="https://ctarequipa.net/bd_op/cond_horariosabado12.php?dni="+dni+"";
        url1domingo1 ="https://ctarequipa.net/bd_op/cond_horariodomingo11.php?dni="+dni+"";
        url1domingo2 ="https://ctarequipa.net/bd_op/cond_horariodomingo12.php?dni="+dni+"";

        url1lunes3 = "https://ctarequipa.net/bd_op/cond_horariolunes13.php?dni="+dni+"";
        url1lunes4 = "https://ctarequipa.net/bd_op/cond_horariolunes14.php?dni="+dni+"";
        url1lunes5 = "https://ctarequipa.net/bd_op/cond_horariolunes15.php?dni="+dni+"";
        url1lunes6 = "https://ctarequipa.net/bd_op/cond_horariolunes16.php?dni="+dni+"";

        url1martes3 ="https://ctarequipa.net/bd_op/cond_horariomartes13.php?dni="+dni+"";
        url1martes4 ="https://ctarequipa.net/bd_op/cond_horariomartes14.php?dni="+dni+"";
        url1martes5 ="https://ctarequipa.net/bd_op/cond_horariomartes15.php?dni="+dni+"";
        url1martes6 ="https://ctarequipa.net/bd_op/cond_horariomartes16.php?dni="+dni+"";

        url1miercoles3 ="https://ctarequipa.net/bd_op/cond_horariomiercoles13.php?dni="+dni+"";
        url1miercoles4 ="https://ctarequipa.net/bd_op/cond_horariomiercoles14.php?dni="+dni+"";
        url1miercoles5 ="https://ctarequipa.net/bd_op/cond_horariomiercoles15.php?dni="+dni+"";
        url1miercoles6 ="https://ctarequipa.net/bd_op/cond_horariomiercoles16.php?dni="+dni+"";

        url1jueves3 ="https://ctarequipa.net/bd_op/cond_horariojueves13.php?dni="+dni+"";
        url1jueves4 ="https://ctarequipa.net/bd_op/cond_horariojueves14.php?dni="+dni+"";
        url1jueves5 ="https://ctarequipa.net/bd_op/cond_horariojueves15.php?dni="+dni+"";
        url1jueves6 ="https://ctarequipa.net/bd_op/cond_horariojueves16.php?dni="+dni+"";

        url1viernes3 ="https://ctarequipa.net/bd_op/cond_horarioviernes13.php?dni="+dni+"";
        url1viernes4 ="https://ctarequipa.net/bd_op/cond_horarioviernes14.php?dni="+dni+"";
        url1viernes5 ="https://ctarequipa.net/bd_op/cond_horarioviernes15.php?dni="+dni+"";
        url1viernes6 ="https://ctarequipa.net/bd_op/cond_horarioviernes16.php?dni="+dni+"";

        url1sabado3 ="https://ctarequipa.net/bd_op/cond_horariosabado13.php?dni="+dni+"";
        url1sabado4 ="https://ctarequipa.net/bd_op/cond_horariosabado14.php?dni="+dni+"";
        url1sabado5 ="https://ctarequipa.net/bd_op/cond_horariosabado15.php?dni="+dni+"";
        url1sabado6 ="https://ctarequipa.net/bd_op/cond_horariosabado16.php?dni="+dni+"";

        url1domingo3 ="https://ctarequipa.net/bd_op/cond_horariodomingo13.php?dni="+dni+"";
        url1domingo4 ="https://ctarequipa.net/bd_op/cond_horariodomingo14.php?dni="+dni+"";
        url1domingo5 ="https://ctarequipa.net/bd_op/cond_horariodomingo15.php?dni="+dni+"";
        url1domingo6 ="https://ctarequipa.net/bd_op/cond_horariodomingo16.php?dni="+dni+"";

        url2lunes1 ="https://ctarequipa.net/bd_op/cond_horariolunes21.php?dni="+dni+"";
        url2lunes2 ="https://ctarequipa.net/bd_op/cond_horariolunes22.php?dni="+dni+"";
        url2lunes3 ="https://ctarequipa.net/bd_op/cond_horariolunes23.php?dni="+dni+"";
        url2lunes4 ="https://ctarequipa.net/bd_op/cond_horariolunes24.php?dni="+dni+"";
        url2lunes5 ="https://ctarequipa.net/bd_op/cond_horariolunes25.php?dni="+dni+"";
        url2lunes6 ="https://ctarequipa.net/bd_op/cond_horariolunes26.php?dni="+dni+"";
        url2martes1 ="https://ctarequipa.net/bd_op/cond_horariomartes21.php?dni="+dni+"";
        url2martes2 ="https://ctarequipa.net/bd_op/cond_horariomartes22.php?dni="+dni+"";
        url2martes3 ="https://ctarequipa.net/bd_op/cond_horariomartes23.php?dni="+dni+"";
        url2martes4 ="https://ctarequipa.net/bd_op/cond_horariomartes24.php?dni="+dni+"";
        url2martes5 ="https://ctarequipa.net/bd_op/cond_horariomartes25.php?dni="+dni+"";
        url2martes6 ="https://ctarequipa.net/bd_op/cond_horariomartes26.php?dni="+dni+"";
        url2miercoles1 ="https://ctarequipa.net/bd_op/cond_horariomiercoles21.php?dni="+dni+"";
        url2miercoles2 ="https://ctarequipa.net/bd_op/cond_horariomiercoles22.php?dni="+dni+"";
        url2miercoles3 ="https://ctarequipa.net/bd_op/cond_horariomiercoles23.php?dni="+dni+"";
        url2miercoles4 ="https://ctarequipa.net/bd_op/cond_horariomiercoles24.php?dni="+dni+"";
        url2miercoles5 ="https://ctarequipa.net/bd_op/cond_horariomiercoles25.php?dni="+dni+"";
        url2miercoles6 ="https://ctarequipa.net/bd_op/cond_horariomiercoles26.php?dni="+dni+"";
        url2jueves1 ="https://ctarequipa.net/bd_op/cond_horariojueves21.php?dni="+dni+"";
        url2jueves2 ="https://ctarequipa.net/bd_op/cond_horariojueves22.php?dni="+dni+"";
        url2jueves3 ="https://ctarequipa.net/bd_op/cond_horariojueves23.php?dni="+dni+"";
        url2jueves4 ="https://ctarequipa.net/bd_op/cond_horariojueves24.php?dni="+dni+"";
        url2jueves5 ="https://ctarequipa.net/bd_op/cond_horariojueves25.php?dni="+dni+"";
        url2jueves6 ="https://ctarequipa.net/bd_op/cond_horariojueves26.php?dni="+dni+"";
        url2viernes1 ="https://ctarequipa.net/bd_op/cond_horarioviernes21.php?dni="+dni+"";
        url2viernes2 ="https://ctarequipa.net/bd_op/cond_horarioviernes22.php?dni="+dni+"";
        url2viernes3 ="https://ctarequipa.net/bd_op/cond_horarioviernes23.php?dni="+dni+"";
        url2viernes4 ="https://ctarequipa.net/bd_op/cond_horarioviernes24.php?dni="+dni+"";
        url2viernes5 ="https://ctarequipa.net/bd_op/cond_horarioviernes25.php?dni="+dni+"";
        url2viernes6 ="https://ctarequipa.net/bd_op/cond_horarioviernes26.php?dni="+dni+"";
        url2sabado1 ="https://ctarequipa.net/bd_op/cond_horariosabado21.php?dni="+dni+"";
        url2sabado2 ="https://ctarequipa.net/bd_op/cond_horariosabado22.php?dni="+dni+"";
        url2sabado3 ="https://ctarequipa.net/bd_op/cond_horariosabado23.php?dni="+dni+"";
        url2sabado4 ="https://ctarequipa.net/bd_op/cond_horariosabado24.php?dni="+dni+"";
        url2sabado5 ="https://ctarequipa.net/bd_op/cond_horariosabado25.php?dni="+dni+"";
        url2sabado6 ="https://ctarequipa.net/bd_op/cond_horariosabado26.php?dni="+dni+"";
        url2domingo1 ="https://ctarequipa.net/bd_op/cond_horariodomingo21.php?dni="+dni+"";
        url2domingo2 ="https://ctarequipa.net/bd_op/cond_horariodomingo22.php?dni="+dni+"";
        url2domingo3 ="https://ctarequipa.net/bd_op/cond_horariodomingo23.php?dni="+dni+"";
        url2domingo4 ="https://ctarequipa.net/bd_op/cond_horariodomingo24.php?dni="+dni+"";
        url2domingo5 ="https://ctarequipa.net/bd_op/cond_horariodomingo25.php?dni="+dni+"";
        url2domingo6 ="https://ctarequipa.net/bd_op/cond_horariodomingo26.php?dni="+dni+"";

        url3lunes1 ="https://ctarequipa.net/bd_op/cond_lablunes31.php?dni="+dni+"";
        url3lunes2 ="https://ctarequipa.net/bd_op/cond_lablunes32.php?dni="+dni+"";
        url3lunes3 ="https://ctarequipa.net/bd_op/cond_lablunes33.php?dni="+dni+"";
        url3lunes4 ="https://ctarequipa.net/bd_op/cond_lablunes34.php?dni="+dni+"";
        url3lunes5 ="https://ctarequipa.net/bd_op/cond_lablunes35.php?dni="+dni+"";
        url3lunes6 ="https://ctarequipa.net/bd_op/cond_lablunes36.php?dni="+dni+"";
        url3martes1 ="https://ctarequipa.net/bd_op/cond_labmartes31.php?dni="+dni+"";
        url3martes2 ="https://ctarequipa.net/bd_op/cond_labmartes32.php?dni="+dni+"";
        url3martes3 ="https://ctarequipa.net/bd_op/cond_labmartes33.php?dni="+dni+"";
        url3martes4 ="https://ctarequipa.net/bd_op/cond_labmartes34.php?dni="+dni+"";
        url3martes5 ="https://ctarequipa.net/bd_op/cond_labmartes35.php?dni="+dni+"";
        url3martes6 ="https://ctarequipa.net/bd_op/cond_labmartes36.php?dni="+dni+"";
        url3miercoles1 ="https://ctarequipa.net/bd_op/cond_labmiercoles31.php?dni="+dni+"";
        url3miercoles2 ="https://ctarequipa.net/bd_op/cond_labmiercoles32.php?dni="+dni+"";
        url3miercoles3 ="https://ctarequipa.net/bd_op/cond_labmiercoles33.php?dni="+dni+"";
        url3miercoles4 ="https://ctarequipa.net/bd_op/cond_labmiercoles34.php?dni="+dni+"";
        url3miercoles5 ="https://ctarequipa.net/bd_op/cond_labmiercoles35.php?dni="+dni+"";
        url3miercoles6 ="https://ctarequipa.net/bd_op/cond_labmiercoles36.php?dni="+dni+"";
        url3jueves1 ="https://ctarequipa.net/bd_op/cond_labjueves31.php?dni="+dni+"";
        url3jueves2 ="https://ctarequipa.net/bd_op/cond_labjueves32.php?dni="+dni+"";
        url3jueves3 ="https://ctarequipa.net/bd_op/cond_labjueves33.php?dni="+dni+"";
        url3jueves4 ="https://ctarequipa.net/bd_op/cond_labjueves34.php?dni="+dni+"";
        url3jueves5 ="https://ctarequipa.net/bd_op/cond_labjueves35.php?dni="+dni+"";
        url3jueves6 ="https://ctarequipa.net/bd_op/cond_labjueves36.php?dni="+dni+"";
        url3viernes1 ="https://ctarequipa.net/bd_op/cond_labviernes31.php?dni="+dni+"";
        url3viernes2 ="https://ctarequipa.net/bd_op/cond_labviernes32.php?dni="+dni+"";
        url3viernes3 ="https://ctarequipa.net/bd_op/cond_labviernes33.php?dni="+dni+"";
        url3viernes4 ="https://ctarequipa.net/bd_op/cond_labviernes34.php?dni="+dni+"";
        url3viernes5 ="https://ctarequipa.net/bd_op/cond_labviernes35.php?dni="+dni+"";
        url3viernes6 ="https://ctarequipa.net/bd_op/cond_labviernes36.php?dni="+dni+"";
        url3sabado1 ="https://ctarequipa.net/bd_op/cond_labsabado31.php?dni="+dni+"";
        url3sabado2 ="https://ctarequipa.net/bd_op/cond_labsabado32.php?dni="+dni+"";
        url3sabado3 ="https://ctarequipa.net/bd_op/cond_labsabado33.php?dni="+dni+"";
        url3sabado4 ="https://ctarequipa.net/bd_op/cond_labsabado34.php?dni="+dni+"";
        url3sabado5 ="https://ctarequipa.net/bd_op/cond_labsabado35.php?dni="+dni+"";
        url3sabado6 ="https://ctarequipa.net/bd_op/cond_labsabado36.php?dni="+dni+"";
        url3domingo1 ="https://ctarequipa.net/bd_op/cond_labdomingo31.php?dni="+dni+"";
        url3domingo2 ="https://ctarequipa.net/bd_op/cond_labdomingo32.php?dni="+dni+"";
        url3domingo3 ="https://ctarequipa.net/bd_op/cond_labdomingo33.php?dni="+dni+"";
        url3domingo4 ="https://ctarequipa.net/bd_op/cond_labdomingo34.php?dni="+dni+"";
        url3domingo5 ="https://ctarequipa.net/bd_op/cond_labdomingo35.php?dni="+dni+"";
        url3domingo6 ="https://ctarequipa.net/bd_op/cond_labdomingo36.php?dni="+dni+"";

        url3semana1 ="https://ctarequipa.net/bd_op/cond_labsemana01.php?dni="+dni+"";
        url3semana2 ="https://ctarequipa.net/bd_op/cond_labsemana02.php?dni="+dni+"";
        url3semana3 ="https://ctarequipa.net/bd_op/cond_labsemana03.php?dni="+dni+"";
        url3semana4 ="https://ctarequipa.net/bd_op/cond_labsemana04.php?dni="+dni+"";
        url3semana5 ="https://ctarequipa.net/bd_op/cond_labsemana05.php?dni="+dni+"";
        url3semana6 ="https://ctarequipa.net/bd_op/cond_labsemana06.php?dni="+dni+"";




        recyclerView1lunes1=findViewById(R.id.rv_lunes11);
        recyclerView1lunes2=findViewById(R.id.rv_lunes12);
        recyclerView1lunes3=findViewById(R.id.rv_lunes13);
        recyclerView1lunes4=findViewById(R.id.rv_lunes14);
        recyclerView1lunes5=findViewById(R.id.rv_lunes15);
        recyclerView1lunes6=findViewById(R.id.rv_lunes16);
        recyclerView1martes1=findViewById(R.id.rv_martes11);
        recyclerView1martes2=findViewById(R.id.rv_martes12);
        recyclerView1martes3=findViewById(R.id.rv_martes13);
        recyclerView1martes4=findViewById(R.id.rv_martes14);
        recyclerView1martes5=findViewById(R.id.rv_martes15);
        recyclerView1martes6=findViewById(R.id.rv_martes16);
        recyclerView1miercoles1=findViewById(R.id.rv_miercoles11);
        recyclerView1miercoles2=findViewById(R.id.rv_miercoles12);
        recyclerView1miercoles3=findViewById(R.id.rv_miercoles13);
        recyclerView1miercoles4=findViewById(R.id.rv_miercoles14);
        recyclerView1miercoles5=findViewById(R.id.rv_miercoles15);
        recyclerView1miercoles6=findViewById(R.id.rv_miercoles16);
        recyclerView1jueves1=findViewById(R.id.rv_jueves11);
        recyclerView1jueves2=findViewById(R.id.rv_jueves12);
        recyclerView1jueves3=findViewById(R.id.rv_jueves13);
        recyclerView1jueves4=findViewById(R.id.rv_jueves14);
        recyclerView1jueves5=findViewById(R.id.rv_jueves15);
        recyclerView1jueves6=findViewById(R.id.rv_jueves16);
        recyclerView1viernes1=findViewById(R.id.rv_viernes11);
        recyclerView1viernes2=findViewById(R.id.rv_viernes12);
        recyclerView1viernes3=findViewById(R.id.rv_viernes13);
        recyclerView1viernes4=findViewById(R.id.rv_viernes14);
        recyclerView1viernes5=findViewById(R.id.rv_viernes15);
        recyclerView1viernes6=findViewById(R.id.rv_viernes16);
        recyclerView1sabado1=findViewById(R.id.rv_sabado11);
        recyclerView1sabado2=findViewById(R.id.rv_sabado12);
        recyclerView1sabado3=findViewById(R.id.rv_sabado13);
        recyclerView1sabado4=findViewById(R.id.rv_sabado14);
        recyclerView1sabado5=findViewById(R.id.rv_sabado15);
        recyclerView1sabado6=findViewById(R.id.rv_sabado16);
        recyclerView1domingo1=findViewById(R.id.rv_domingo11);
        recyclerView1domingo2=findViewById(R.id.rv_domingo12);
        recyclerView1domingo3=findViewById(R.id.rv_domingo13);
        recyclerView1domingo4=findViewById(R.id.rv_domingo14);
        recyclerView1domingo5=findViewById(R.id.rv_domingo15);
        recyclerView1domingo6=findViewById(R.id.rv_domingo16);

        recyclerView2lunes1=findViewById(R.id.rv_lunes21);
        recyclerView2lunes2=findViewById(R.id.rv_lunes22);
        recyclerView2lunes3=findViewById(R.id.rv_lunes23);
        recyclerView2lunes4=findViewById(R.id.rv_lunes24);
        recyclerView2lunes5=findViewById(R.id.rv_lunes25);
        recyclerView2lunes6=findViewById(R.id.rv_lunes26);
        recyclerView2martes1=findViewById(R.id.rv_martes21);
        recyclerView2martes2=findViewById(R.id.rv_martes22);
        recyclerView2martes3=findViewById(R.id.rv_martes23);
        recyclerView2martes4=findViewById(R.id.rv_martes24);
        recyclerView2martes5=findViewById(R.id.rv_martes25);
        recyclerView2martes6=findViewById(R.id.rv_martes26);
        recyclerView2miercoles1=findViewById(R.id.rv_miercoles21);
        recyclerView2miercoles2=findViewById(R.id.rv_miercoles22);
        recyclerView2miercoles3=findViewById(R.id.rv_miercoles23);
        recyclerView2miercoles4=findViewById(R.id.rv_miercoles24);
        recyclerView2miercoles5=findViewById(R.id.rv_miercoles25);
        recyclerView2miercoles6=findViewById(R.id.rv_miercoles26);
        recyclerView2jueves1=findViewById(R.id.rv_jueves21);
        recyclerView2jueves2=findViewById(R.id.rv_jueves22);
        recyclerView2jueves3=findViewById(R.id.rv_jueves23);
        recyclerView2jueves4=findViewById(R.id.rv_jueves24);
        recyclerView2jueves5=findViewById(R.id.rv_jueves25);
        recyclerView2jueves6=findViewById(R.id.rv_jueves26);
        recyclerView2viernes1=findViewById(R.id.rv_viernes21);
        recyclerView2viernes2=findViewById(R.id.rv_viernes22);
        recyclerView2viernes3=findViewById(R.id.rv_viernes23);
        recyclerView2viernes4=findViewById(R.id.rv_viernes24);
        recyclerView2viernes5=findViewById(R.id.rv_viernes25);
        recyclerView2viernes6=findViewById(R.id.rv_viernes26);
        recyclerView2sabado1=findViewById(R.id.rv_sabado21);
        recyclerView2sabado2=findViewById(R.id.rv_sabado22);
        recyclerView2sabado3=findViewById(R.id.rv_sabado23);
        recyclerView2sabado4=findViewById(R.id.rv_sabado24);
        recyclerView2sabado5=findViewById(R.id.rv_sabado25);
        recyclerView2sabado6=findViewById(R.id.rv_sabado26);
        recyclerView2domingo1=findViewById(R.id.rv_domingo21);
        recyclerView2domingo2=findViewById(R.id.rv_domingo22);
        recyclerView2domingo3=findViewById(R.id.rv_domingo23);
        recyclerView2domingo4=findViewById(R.id.rv_domingo24);
        recyclerView2domingo5=findViewById(R.id.rv_domingo25);
        recyclerView2domingo6=findViewById(R.id.rv_domingo26);



        recyclerView1lunes1=findViewById(R.id.rv_lunes11);
        recyclerView1lunes2=findViewById(R.id.rv_lunes12);
        recyclerView1lunes3=findViewById(R.id.rv_lunes13);
        recyclerView1lunes4=findViewById(R.id.rv_lunes14);
        recyclerView1lunes5=findViewById(R.id.rv_lunes15);
        recyclerView1lunes6=findViewById(R.id.rv_lunes16);
        recyclerView1martes1=findViewById(R.id.rv_martes11);
        recyclerView1martes2=findViewById(R.id.rv_martes12);
        recyclerView1martes3=findViewById(R.id.rv_martes13);
        recyclerView1martes4=findViewById(R.id.rv_martes14);
        recyclerView1martes5=findViewById(R.id.rv_martes15);
        recyclerView1martes6=findViewById(R.id.rv_martes16);
        recyclerView1miercoles1=findViewById(R.id.rv_miercoles11);
        recyclerView1miercoles2=findViewById(R.id.rv_miercoles12);
        recyclerView1miercoles3=findViewById(R.id.rv_miercoles13);
        recyclerView1miercoles4=findViewById(R.id.rv_miercoles14);
        recyclerView1miercoles5=findViewById(R.id.rv_miercoles15);
        recyclerView1miercoles6=findViewById(R.id.rv_miercoles16);
        recyclerView1jueves1=findViewById(R.id.rv_jueves11);
        recyclerView1jueves2=findViewById(R.id.rv_jueves12);
        recyclerView1jueves3=findViewById(R.id.rv_jueves13);
        recyclerView1jueves4=findViewById(R.id.rv_jueves14);
        recyclerView1jueves5=findViewById(R.id.rv_jueves15);
        recyclerView1jueves6=findViewById(R.id.rv_jueves16);
        recyclerView1viernes1=findViewById(R.id.rv_viernes11);
        recyclerView1viernes2=findViewById(R.id.rv_viernes12);
        recyclerView1viernes3=findViewById(R.id.rv_viernes13);
        recyclerView1viernes4=findViewById(R.id.rv_viernes14);
        recyclerView1viernes5=findViewById(R.id.rv_viernes15);
        recyclerView1viernes6=findViewById(R.id.rv_viernes16);
        recyclerView1sabado1=findViewById(R.id.rv_sabado11);
        recyclerView1sabado2=findViewById(R.id.rv_sabado12);
        recyclerView1sabado3=findViewById(R.id.rv_sabado13);
        recyclerView1sabado4=findViewById(R.id.rv_sabado14);
        recyclerView1sabado5=findViewById(R.id.rv_sabado15);
        recyclerView1sabado6=findViewById(R.id.rv_sabado16);
        recyclerView1domingo1=findViewById(R.id.rv_domingo11);
        recyclerView1domingo2=findViewById(R.id.rv_domingo12);
        recyclerView1domingo3=findViewById(R.id.rv_domingo13);
        recyclerView1domingo4=findViewById(R.id.rv_domingo14);
        recyclerView1domingo5=findViewById(R.id.rv_domingo15);
        recyclerView1domingo6=findViewById(R.id.rv_domingo16);

        recyclerView2lunes1=findViewById(R.id.rv_lunes21);
        recyclerView2lunes2=findViewById(R.id.rv_lunes22);
        recyclerView2lunes3=findViewById(R.id.rv_lunes23);
        recyclerView2lunes4=findViewById(R.id.rv_lunes24);
        recyclerView2lunes5=findViewById(R.id.rv_lunes25);
        recyclerView2lunes6=findViewById(R.id.rv_lunes26);
        recyclerView2martes1=findViewById(R.id.rv_martes21);
        recyclerView2martes2=findViewById(R.id.rv_martes22);
        recyclerView2martes3=findViewById(R.id.rv_martes23);
        recyclerView2martes4=findViewById(R.id.rv_martes24);
        recyclerView2martes5=findViewById(R.id.rv_martes25);
        recyclerView2martes6=findViewById(R.id.rv_martes26);
        recyclerView2miercoles1=findViewById(R.id.rv_miercoles21);
        recyclerView2miercoles2=findViewById(R.id.rv_miercoles22);
        recyclerView2miercoles3=findViewById(R.id.rv_miercoles23);
        recyclerView2miercoles4=findViewById(R.id.rv_miercoles24);
        recyclerView2miercoles5=findViewById(R.id.rv_miercoles25);
        recyclerView2miercoles6=findViewById(R.id.rv_miercoles26);
        recyclerView2jueves1=findViewById(R.id.rv_jueves21);
        recyclerView2jueves2=findViewById(R.id.rv_jueves22);
        recyclerView2jueves3=findViewById(R.id.rv_jueves23);
        recyclerView2jueves4=findViewById(R.id.rv_jueves24);
        recyclerView2jueves5=findViewById(R.id.rv_jueves25);
        recyclerView2jueves6=findViewById(R.id.rv_jueves26);
        recyclerView2viernes1=findViewById(R.id.rv_viernes21);
        recyclerView2viernes2=findViewById(R.id.rv_viernes22);
        recyclerView2viernes3=findViewById(R.id.rv_viernes23);
        recyclerView2viernes4=findViewById(R.id.rv_viernes24);
        recyclerView2viernes5=findViewById(R.id.rv_viernes25);
        recyclerView2viernes6=findViewById(R.id.rv_viernes26);
        recyclerView2sabado1=findViewById(R.id.rv_sabado21);
        recyclerView2sabado2=findViewById(R.id.rv_sabado22);
        recyclerView2sabado3=findViewById(R.id.rv_sabado23);
        recyclerView2sabado4=findViewById(R.id.rv_sabado24);
        recyclerView2sabado5=findViewById(R.id.rv_sabado25);
        recyclerView2sabado6=findViewById(R.id.rv_sabado26);
        recyclerView2domingo1=findViewById(R.id.rv_domingo21);
        recyclerView2domingo2=findViewById(R.id.rv_domingo22);
        recyclerView2domingo3=findViewById(R.id.rv_domingo23);
        recyclerView2domingo4=findViewById(R.id.rv_domingo24);
        recyclerView2domingo5=findViewById(R.id.rv_domingo25);
        recyclerView2domingo6=findViewById(R.id.rv_domingo26);


        recyclerView3lunes1 =findViewById(R.id.rv_lunes31);
        recyclerView3lunes2 =findViewById(R.id.rv_lunes32);
        recyclerView3lunes3 =findViewById(R.id.rv_lunes33);
        recyclerView3lunes4 =findViewById(R.id.rv_lunes34);
        recyclerView3lunes5 =findViewById(R.id.rv_lunes35);
        recyclerView3lunes6 =findViewById(R.id.rv_lunes36);
        recyclerView3martes1 =findViewById(R.id.rv_martes31);
        recyclerView3martes2 =findViewById(R.id.rv_martes32);
        recyclerView3martes3 =findViewById(R.id.rv_martes33);
        recyclerView3martes4 =findViewById(R.id.rv_martes34);
        recyclerView3martes5 =findViewById(R.id.rv_martes35);
        recyclerView3martes6 =findViewById(R.id.rv_martes36);
        recyclerView3miercoles1 =findViewById(R.id.rv_miercoles31);
        recyclerView3miercoles2 =findViewById(R.id.rv_miercoles32);
        recyclerView3miercoles3 =findViewById(R.id.rv_miercoles33);
        recyclerView3miercoles4 =findViewById(R.id.rv_miercoles34);
        recyclerView3miercoles5 =findViewById(R.id.rv_miercoles35);
        recyclerView3miercoles6 =findViewById(R.id.rv_miercoles36);
        recyclerView3jueves1 =findViewById(R.id.rv_jueve31);
        recyclerView3jueves2 =findViewById(R.id.rv_jueves32);
        recyclerView3jueves3 =findViewById(R.id.rv_jueves33);
        recyclerView3jueves4 =findViewById(R.id.rv_jueves34);
        recyclerView3jueves5 =findViewById(R.id.rv_jueves35);
        recyclerView3jueves6 =findViewById(R.id.rv_jueves36);
        recyclerView3viernes1 =findViewById(R.id.rv_viernes31);
        recyclerView3viernes2 =findViewById(R.id.rv_viernes32);
        recyclerView3viernes3 =findViewById(R.id.rv_viernes33);
        recyclerView3viernes4 =findViewById(R.id.rv_viernes34);
        recyclerView3viernes5 =findViewById(R.id.rv_viernes35);
        recyclerView3viernes6 =findViewById(R.id.rv_viernes36);
        recyclerView3sabado1 =findViewById(R.id.rv_sabado31);
        recyclerView3sabado2 =findViewById(R.id.rv_sabado32);
        recyclerView3sabado3 =findViewById(R.id.rv_sabado33);
        recyclerView3sabado4 =findViewById(R.id.rv_sabado34);
        recyclerView3sabado5 =findViewById(R.id.rv_sabado35);
        recyclerView3sabado6 =findViewById(R.id.rv_sabado36);
        recyclerView3domingo1 =findViewById(R.id.rv_domingo31);
        recyclerView3domingo2 =findViewById(R.id.rv_domingo32);
        recyclerView3domingo3 =findViewById(R.id.rv_domingo33);
        recyclerView3domingo4 =findViewById(R.id.rv_domingo34);
        recyclerView3domingo5 =findViewById(R.id.rv_domingo35);
        recyclerView3domingo6 =findViewById(R.id.rv_domingo36);
        recyclerView3semana1 =findViewById(R.id.rv_hora31);
        recyclerView3semana2 =findViewById(R.id.rv_hora32);
        recyclerView3semana3 =findViewById(R.id.rv_hora33);
        recyclerView3semana4 =findViewById(R.id.rv_hora34);
        recyclerView3semana5 =findViewById(R.id.rv_hora35);
        recyclerView3semana6 =findViewById(R.id.rv_hora36);


        recyclerView1lunes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes1.setHasFixedSize(true);
        recyclerView1lunes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes2.setHasFixedSize(true);
        recyclerView1lunes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes3.setHasFixedSize(true);
        recyclerView1lunes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes4.setHasFixedSize(true);
        recyclerView1lunes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes5.setHasFixedSize(true);
        recyclerView1lunes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes6.setHasFixedSize(true);
        recyclerView1martes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes1.setHasFixedSize(true);
        recyclerView1martes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes2.setHasFixedSize(true);
        recyclerView1martes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes3.setHasFixedSize(true);
        recyclerView1martes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes4.setHasFixedSize(true);
        recyclerView1martes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes5.setHasFixedSize(true);
        recyclerView1martes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes6.setHasFixedSize(true);
        recyclerView1miercoles1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles1.setHasFixedSize(true);
        recyclerView1miercoles2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles2.setHasFixedSize(true);
        recyclerView1miercoles3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles3.setHasFixedSize(true);
        recyclerView1miercoles4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles4.setHasFixedSize(true);
        recyclerView1miercoles5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles5.setHasFixedSize(true);
        recyclerView1miercoles6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles6.setHasFixedSize(true);
        recyclerView1jueves1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves1.setHasFixedSize(true);
        recyclerView1jueves2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves2.setHasFixedSize(true);
        recyclerView1jueves3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves3.setHasFixedSize(true);
        recyclerView1jueves4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves4.setHasFixedSize(true);
        recyclerView1jueves5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves5.setHasFixedSize(true);
        recyclerView1jueves6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves6.setHasFixedSize(true);
        recyclerView1viernes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes1.setHasFixedSize(true);
        recyclerView1viernes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes2.setHasFixedSize(true);
        recyclerView1viernes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes3.setHasFixedSize(true);
        recyclerView1viernes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes4.setHasFixedSize(true);
        recyclerView1viernes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes5.setHasFixedSize(true);
        recyclerView1viernes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes6.setHasFixedSize(true);
        recyclerView1sabado1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado1.setHasFixedSize(true);
        recyclerView1sabado2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado2.setHasFixedSize(true);
        recyclerView1sabado3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado3.setHasFixedSize(true);
        recyclerView1sabado4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado4.setHasFixedSize(true);
        recyclerView1sabado5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado5.setHasFixedSize(true);
        recyclerView1sabado6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado6.setHasFixedSize(true);
        recyclerView1domingo1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo1.setHasFixedSize(true);
        recyclerView1domingo2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo2.setHasFixedSize(true);
        recyclerView1domingo3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo3.setHasFixedSize(true);
        recyclerView1domingo4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo4.setHasFixedSize(true);
        recyclerView1domingo5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo5.setHasFixedSize(true);
        recyclerView1domingo6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo6.setHasFixedSize(true);

        recyclerView2lunes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes1.setHasFixedSize(true);
        recyclerView2lunes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes2.setHasFixedSize(true);
        recyclerView2lunes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes3.setHasFixedSize(true);
        recyclerView2lunes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes4.setHasFixedSize(true);
        recyclerView2lunes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes5.setHasFixedSize(true);
        recyclerView2lunes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes6.setHasFixedSize(true);
        recyclerView2martes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes1.setHasFixedSize(true);
        recyclerView2martes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes2.setHasFixedSize(true);
        recyclerView2martes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes3.setHasFixedSize(true);
        recyclerView2martes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes4.setHasFixedSize(true);
        recyclerView2martes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes5.setHasFixedSize(true);
        recyclerView2martes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes6.setHasFixedSize(true);
        recyclerView2miercoles1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles1.setHasFixedSize(true);
        recyclerView2miercoles2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles2.setHasFixedSize(true);
        recyclerView2miercoles3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles3.setHasFixedSize(true);
        recyclerView2miercoles4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles4.setHasFixedSize(true);
        recyclerView2miercoles5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles5.setHasFixedSize(true);
        recyclerView2miercoles6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles6.setHasFixedSize(true);
        recyclerView2jueves1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves1.setHasFixedSize(true);
        recyclerView2jueves2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves2.setHasFixedSize(true);
        recyclerView2jueves3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves3.setHasFixedSize(true);
        recyclerView2jueves4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves4.setHasFixedSize(true);
        recyclerView2jueves5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves5.setHasFixedSize(true);
        recyclerView2jueves6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves6.setHasFixedSize(true);
        recyclerView2viernes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes1.setHasFixedSize(true);
        recyclerView2viernes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes2.setHasFixedSize(true);
        recyclerView2viernes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes3.setHasFixedSize(true);
        recyclerView2viernes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes4.setHasFixedSize(true);
        recyclerView2viernes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes5.setHasFixedSize(true);
        recyclerView2viernes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes6.setHasFixedSize(true);
        recyclerView2sabado1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado1.setHasFixedSize(true);
        recyclerView2sabado2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado2.setHasFixedSize(true);
        recyclerView2sabado3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado3.setHasFixedSize(true);
        recyclerView2sabado4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado4.setHasFixedSize(true);
        recyclerView2sabado5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado5.setHasFixedSize(true);
        recyclerView2sabado6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado6.setHasFixedSize(true);
        recyclerView2domingo1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo1.setHasFixedSize(true);
        recyclerView2domingo2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo2.setHasFixedSize(true);
        recyclerView2domingo3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo3.setHasFixedSize(true);
        recyclerView2domingo4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo4.setHasFixedSize(true);
        recyclerView2domingo5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo5.setHasFixedSize(true);
        recyclerView2domingo6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo6.setHasFixedSize(true);

        recyclerView1lunes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes1.setHasFixedSize(true);
        recyclerView1lunes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes2.setHasFixedSize(true);
        recyclerView1lunes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes3.setHasFixedSize(true);
        recyclerView1lunes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes4.setHasFixedSize(true);
        recyclerView1lunes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes5.setHasFixedSize(true);
        recyclerView1lunes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1lunes6.setHasFixedSize(true);
        recyclerView1martes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes1.setHasFixedSize(true);
        recyclerView1martes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes2.setHasFixedSize(true);
        recyclerView1martes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes3.setHasFixedSize(true);
        recyclerView1martes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes4.setHasFixedSize(true);
        recyclerView1martes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes5.setHasFixedSize(true);
        recyclerView1martes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1martes6.setHasFixedSize(true);
        recyclerView1miercoles1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles1.setHasFixedSize(true);
        recyclerView1miercoles2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles2.setHasFixedSize(true);
        recyclerView1miercoles3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles3.setHasFixedSize(true);
        recyclerView1miercoles4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles4.setHasFixedSize(true);
        recyclerView1miercoles5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles5.setHasFixedSize(true);
        recyclerView1miercoles6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1miercoles6.setHasFixedSize(true);
        recyclerView1jueves1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves1.setHasFixedSize(true);
        recyclerView1jueves2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves2.setHasFixedSize(true);
        recyclerView1jueves3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves3.setHasFixedSize(true);
        recyclerView1jueves4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves4.setHasFixedSize(true);
        recyclerView1jueves5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves5.setHasFixedSize(true);
        recyclerView1jueves6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1jueves6.setHasFixedSize(true);
        recyclerView1viernes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes1.setHasFixedSize(true);
        recyclerView1viernes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes2.setHasFixedSize(true);
        recyclerView1viernes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes3.setHasFixedSize(true);
        recyclerView1viernes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes4.setHasFixedSize(true);
        recyclerView1viernes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes5.setHasFixedSize(true);
        recyclerView1viernes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1viernes6.setHasFixedSize(true);
        recyclerView1sabado1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado1.setHasFixedSize(true);
        recyclerView1sabado2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado2.setHasFixedSize(true);
        recyclerView1sabado3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado3.setHasFixedSize(true);
        recyclerView1sabado4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado4.setHasFixedSize(true);
        recyclerView1sabado5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado5.setHasFixedSize(true);
        recyclerView1sabado6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1sabado6.setHasFixedSize(true);
        recyclerView1domingo1.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo1.setHasFixedSize(true);
        recyclerView1domingo2.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo2.setHasFixedSize(true);
        recyclerView1domingo3.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo3.setHasFixedSize(true);
        recyclerView1domingo4.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo4.setHasFixedSize(true);
        recyclerView1domingo5.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo5.setHasFixedSize(true);
        recyclerView1domingo6.setLayoutManager(new LinearLayoutManager(this)); recyclerView1domingo6.setHasFixedSize(true);

        recyclerView2lunes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes1.setHasFixedSize(true);
        recyclerView2lunes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes2.setHasFixedSize(true);
        recyclerView2lunes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes3.setHasFixedSize(true);
        recyclerView2lunes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes4.setHasFixedSize(true);
        recyclerView2lunes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes5.setHasFixedSize(true);
        recyclerView2lunes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2lunes6.setHasFixedSize(true);
        recyclerView2martes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes1.setHasFixedSize(true);
        recyclerView2martes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes2.setHasFixedSize(true);
        recyclerView2martes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes3.setHasFixedSize(true);
        recyclerView2martes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes4.setHasFixedSize(true);
        recyclerView2martes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes5.setHasFixedSize(true);
        recyclerView2martes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2martes6.setHasFixedSize(true);
        recyclerView2miercoles1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles1.setHasFixedSize(true);
        recyclerView2miercoles2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles2.setHasFixedSize(true);
        recyclerView2miercoles3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles3.setHasFixedSize(true);
        recyclerView2miercoles4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles4.setHasFixedSize(true);
        recyclerView2miercoles5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles5.setHasFixedSize(true);
        recyclerView2miercoles6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2miercoles6.setHasFixedSize(true);
        recyclerView2jueves1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves1.setHasFixedSize(true);
        recyclerView2jueves2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves2.setHasFixedSize(true);
        recyclerView2jueves3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves3.setHasFixedSize(true);
        recyclerView2jueves4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves4.setHasFixedSize(true);
        recyclerView2jueves5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves5.setHasFixedSize(true);
        recyclerView2jueves6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2jueves6.setHasFixedSize(true);
        recyclerView2viernes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes1.setHasFixedSize(true);
        recyclerView2viernes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes2.setHasFixedSize(true);
        recyclerView2viernes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes3.setHasFixedSize(true);
        recyclerView2viernes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes4.setHasFixedSize(true);
        recyclerView2viernes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes5.setHasFixedSize(true);
        recyclerView2viernes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2viernes6.setHasFixedSize(true);
        recyclerView2sabado1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado1.setHasFixedSize(true);
        recyclerView2sabado2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado2.setHasFixedSize(true);
        recyclerView2sabado3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado3.setHasFixedSize(true);
        recyclerView2sabado4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado4.setHasFixedSize(true);
        recyclerView2sabado5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado5.setHasFixedSize(true);
        recyclerView2sabado6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2sabado6.setHasFixedSize(true);
        recyclerView2domingo1.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo1.setHasFixedSize(true);
        recyclerView2domingo2.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo2.setHasFixedSize(true);
        recyclerView2domingo3.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo3.setHasFixedSize(true);
        recyclerView2domingo4.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo4.setHasFixedSize(true);
        recyclerView2domingo5.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo5.setHasFixedSize(true);
        recyclerView2domingo6.setLayoutManager(new LinearLayoutManager(this)); recyclerView2domingo6.setHasFixedSize(true);


        recyclerView3lunes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView3lunes1.setHasFixedSize(true);
        recyclerView3lunes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView3lunes2.setHasFixedSize(true);
        recyclerView3lunes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView3lunes3.setHasFixedSize(true);
        recyclerView3lunes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView3lunes4.setHasFixedSize(true);
        recyclerView3lunes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView3lunes5.setHasFixedSize(true);
        recyclerView3lunes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView3lunes6.setHasFixedSize(true);
        recyclerView3martes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView3martes1.setHasFixedSize(true);
        recyclerView3martes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView3martes2.setHasFixedSize(true);
        recyclerView3martes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView3martes3.setHasFixedSize(true);
        recyclerView3martes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView3martes4.setHasFixedSize(true);
        recyclerView3martes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView3martes5.setHasFixedSize(true);
        recyclerView3martes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView3martes6.setHasFixedSize(true);
        recyclerView3miercoles1.setLayoutManager(new LinearLayoutManager(this)); recyclerView3miercoles1.setHasFixedSize(true);
        recyclerView3miercoles2.setLayoutManager(new LinearLayoutManager(this)); recyclerView3miercoles2.setHasFixedSize(true);
        recyclerView3miercoles3.setLayoutManager(new LinearLayoutManager(this)); recyclerView3miercoles3.setHasFixedSize(true);
        recyclerView3miercoles4.setLayoutManager(new LinearLayoutManager(this)); recyclerView3miercoles4.setHasFixedSize(true);
        recyclerView3miercoles5.setLayoutManager(new LinearLayoutManager(this)); recyclerView3miercoles5.setHasFixedSize(true);
        recyclerView3miercoles6.setLayoutManager(new LinearLayoutManager(this)); recyclerView3miercoles6.setHasFixedSize(true);
        recyclerView3jueves1.setLayoutManager(new LinearLayoutManager(this)); recyclerView3jueves1.setHasFixedSize(true);
        recyclerView3jueves2.setLayoutManager(new LinearLayoutManager(this)); recyclerView3jueves2.setHasFixedSize(true);
        recyclerView3jueves3.setLayoutManager(new LinearLayoutManager(this)); recyclerView3jueves3.setHasFixedSize(true);
        recyclerView3jueves4.setLayoutManager(new LinearLayoutManager(this)); recyclerView3jueves4.setHasFixedSize(true);
        recyclerView3jueves5.setLayoutManager(new LinearLayoutManager(this)); recyclerView3jueves5.setHasFixedSize(true);
        recyclerView3jueves6.setLayoutManager(new LinearLayoutManager(this)); recyclerView3jueves6.setHasFixedSize(true);
        recyclerView3viernes1.setLayoutManager(new LinearLayoutManager(this)); recyclerView3viernes1.setHasFixedSize(true);
        recyclerView3viernes2.setLayoutManager(new LinearLayoutManager(this)); recyclerView3viernes2.setHasFixedSize(true);
        recyclerView3viernes3.setLayoutManager(new LinearLayoutManager(this)); recyclerView3viernes3.setHasFixedSize(true);
        recyclerView3viernes4.setLayoutManager(new LinearLayoutManager(this)); recyclerView3viernes4.setHasFixedSize(true);
        recyclerView3viernes5.setLayoutManager(new LinearLayoutManager(this)); recyclerView3viernes5.setHasFixedSize(true);
        recyclerView3viernes6.setLayoutManager(new LinearLayoutManager(this)); recyclerView3viernes6.setHasFixedSize(true);
        recyclerView3sabado1.setLayoutManager(new LinearLayoutManager(this)); recyclerView3sabado1.setHasFixedSize(true);
        recyclerView3sabado2.setLayoutManager(new LinearLayoutManager(this)); recyclerView3sabado2.setHasFixedSize(true);
        recyclerView3sabado3.setLayoutManager(new LinearLayoutManager(this)); recyclerView3sabado3.setHasFixedSize(true);
        recyclerView3sabado4.setLayoutManager(new LinearLayoutManager(this)); recyclerView3sabado4.setHasFixedSize(true);
        recyclerView3sabado5.setLayoutManager(new LinearLayoutManager(this)); recyclerView3sabado5.setHasFixedSize(true);
        recyclerView3sabado6.setLayoutManager(new LinearLayoutManager(this)); recyclerView3sabado6.setHasFixedSize(true);
        recyclerView3domingo1.setLayoutManager(new LinearLayoutManager(this)); recyclerView3domingo1.setHasFixedSize(true);
        recyclerView3domingo2.setLayoutManager(new LinearLayoutManager(this)); recyclerView3domingo2.setHasFixedSize(true);
        recyclerView3domingo3.setLayoutManager(new LinearLayoutManager(this)); recyclerView3domingo3.setHasFixedSize(true);
        recyclerView3domingo4.setLayoutManager(new LinearLayoutManager(this)); recyclerView3domingo4.setHasFixedSize(true);
        recyclerView3domingo5.setLayoutManager(new LinearLayoutManager(this)); recyclerView3domingo5.setHasFixedSize(true);
        recyclerView3domingo6.setLayoutManager(new LinearLayoutManager(this)); recyclerView3domingo6.setHasFixedSize(true);

        recyclerView3semana1.setLayoutManager(new LinearLayoutManager(this)); recyclerView3semana1.setHasFixedSize(true);
        recyclerView3semana2.setLayoutManager(new LinearLayoutManager(this)); recyclerView3semana2.setHasFixedSize(true);
        recyclerView3semana3.setLayoutManager(new LinearLayoutManager(this)); recyclerView3semana3.setHasFixedSize(true);
        recyclerView3semana4.setLayoutManager(new LinearLayoutManager(this)); recyclerView3semana4.setHasFixedSize(true);
        recyclerView3semana5.setLayoutManager(new LinearLayoutManager(this)); recyclerView3semana5.setHasFixedSize(true);
        recyclerView3semana6.setLayoutManager(new LinearLayoutManager(this)); recyclerView3semana6.setHasFixedSize(true);

        GetData1lunes1();GetData1martes1();GetData1miercoles1();GetData1jueves1();GetData1viernes1();GetData1sabado1();GetData1domingo1();
        GetData1lunes2();GetData1martes2();GetData1miercoles2();GetData1jueves2();GetData1viernes2();GetData1sabado2();GetData1domingo2();



        for (day = -7;  day<=7; day++){
            GetDataday(day);

        }




/*
        GetData1lunes1(); GetData1lunes2(); GetData1lunes3(); GetData1lunes4(); GetData1lunes5(); GetData1lunes6();
        GetData1martes1(); GetData1martes2(); GetData1martes3(); GetData1martes4(); GetData1martes5(); GetData1martes6();
        GetData1miercoles1(); GetData1miercoles2(); GetData1miercoles3(); GetData1miercoles4(); GetData1miercoles5(); GetData1miercoles6();
        GetData1jueves1(); GetData1jueves2();  GetData1jueves3(); GetData1jueves4(); GetData1jueves5(); GetData1jueves6();
        GetData1viernes1();GetData1viernes2();GetData1viernes3();GetData1viernes4();GetData1viernes5();GetData1viernes6();
        GetData1sabado1();GetData1sabado2();GetData1sabado3();GetData1sabado4();GetData1sabado5();GetData1sabado6();
        GetData1domingo1();GetData1domingo2();GetData1domingo3();GetData1domingo4();GetData1domingo5();GetData1domingo6();


        GetData2lunes1();GetData2lunes2();GetData2lunes3();GetData2lunes4();GetData2lunes5();GetData2lunes6();
        GetData2martes1();GetData2martes2();GetData2martes3();GetData2martes4();GetData2martes5();GetData2martes6();
        GetData2miercoles1();GetData2miercoles2();GetData2miercoles3();GetData2miercoles4();GetData2miercoles5();GetData2miercoles6();
        GetData2jueves1();GetData2jueves2();GetData2jueves3();GetData2jueves4();GetData2jueves5();GetData2jueves6();
        GetData2viernes1();GetData2viernes2();GetData2viernes3();GetData2viernes4();GetData2viernes5();GetData2viernes6();
        GetData2sabado1();GetData2sabado2();GetData2sabado3();GetData2sabado4();GetData2sabado5();GetData2sabado6();
        GetData2domingo1();GetData2domingo2();GetData2domingo3();GetData2domingo4();GetData2domingo5();GetData2domingo6();
*/

/*
        GetData3lunes1(); GetData3lunes2(); GetData3lunes3(); GetData3lunes4(); GetData3lunes5(); GetData3lunes6();
        GetData3martes1(); GetData3martes2(); GetData3martes3(); GetData3martes4(); GetData3martes5(); GetData3martes6();
        GetData3miercoles1(); GetData3miercoles2(); GetData3miercoles3(); GetData3miercoles4(); GetData3miercoles5(); GetData3miercoles6();
        GetData3jueves1(); GetData3jueves2();  GetData3jueves3(); GetData3jueves4(); GetData3jueves5(); GetData3jueves6();
        GetData3viernes1(); GetData3viernes2(); GetData3viernes3(); GetData3viernes4(); GetData3viernes5(); GetData3viernes6();
        GetData3sabado1(); GetData3sabado2(); GetData3sabado3(); GetData3sabado4(); GetData3sabado5(); GetData3sabado6();
        GetData3domingo1(); GetData3domingo2(); GetData3domingo3(); GetData3domingo4(); GetData3domingo5(); GetData3domingo6();

        GetData3semana1();GetData3semana2();GetData3semana3();GetData3semana4();GetData3semana5();GetData3semana6();

*/
        TextView semana31,semana32,semana33,semana34,semana35,semana36;
        semana31=findViewById(R.id.semana31);
        semana32=findViewById(R.id.semana32);
        semana33=findViewById(R.id.semana33);
        semana34=findViewById(R.id.semana34);
        semana35=findViewById(R.id.semana35);
        semana36=findViewById(R.id.semana36);


        Calendar calendar3 = Calendar.getInstance();

        int cmes=calendar3.get(Calendar.MONTH)+1;
        int caño=calendar3.get(Calendar.YEAR);
        int cdiafin=calendar3.getActualMaximum(Calendar.DAY_OF_MONTH);

        LocalDate cdf=LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());

        DayOfWeek dia = cdf.getDayOfWeek();
        int dias = dia.getValue();

        int cdia12=1-dias+7;
        int cdia22=1-dias+14;
        int cdia32=1-dias+21;
        int cdia42=1-dias+28;

        semana31.setText("Del 1-"+cmes+"-"+caño+"    al  "+cdia12+"-"+cmes+"-"+caño);
        semana32.setText("Del "+(cdia12+1)+"-"+cmes+"-"+caño+"    al  "+cdia22+"-"+cmes+"-"+caño);
        semana33.setText("Del "+(cdia22+1)+"-"+cmes+"-"+caño+"    al  "+cdia32+"-"+cmes+"-"+caño);
        semana34.setText("Del "+(cdia32+1)+"-"+cmes+"-"+caño+"    al  "+cdia42+"-"+cmes+"-"+caño);

        int cdia52=1-dias+35;

        if(cdia42==28){}
        else if(cdia52==30 || cdia52==29)
        {   semana35.setText("Del "+(cdia42+1)+"-"+cmes+"-"+caño+"    al  "+cdia52+"-"+cmes+"-"+caño);
            semana36.setText("Del "+(cdia52+1)+"-"+cmes+"-"+caño+"    al  "+cdiafin+"-"+cmes+"-"+caño);}
        else {  semana35.setText("Del "+(cdia42+1)+"-"+cmes+"-"+caño+"    al  "+cdiafin+"-"+cmes+"-"+caño);}


        TextView mes_fecha, mes_fecha2;
        mes_fecha=findViewById(R.id.mes_fecha);
        Calendar calendar = Calendar.getInstance();
        int nD =-1;
        nD=calendar.get(Calendar.MONTH);
        String nom="";
        switch (nD) {
            case 0:nom = "ENERO";
                break;
            case 1:nom = "FEBRERO";
                break;
            case 2:nom = "MARZO";
                break;
            case 3:nom = "ABRIL";
                break;
            case 4:nom = "MAYO";
                break;
            case 5:nom = "JUNIO";
                break;
            case 6:nom = "JULIO";
                break;
            case 7:nom = "AGOSTO";
                break;
            case 8:nom = "SEPTIEMBRE";
                break;
            case 9:nom = "OCTUBRE";
                break;
            case 10:nom = "NOVIEMBRE";
                break;
            case 11:nom = "DICIEMBRE";
                break;
        }
        mes_fecha.setText(nom);

        mes_fecha2=findViewById(R.id.mes_fecha2);
        Calendar calendar2 = Calendar.getInstance();
        int nD2 =-1;
        nD2=calendar2.get(Calendar.MONTH);
        int nDS = nD2+1;
        String nom2="";
        switch (nDS) {
            case 12:nom2 = "ENERO";
                break;
            case 1:nom2 = "FEBRERO";
                break;
            case 2:nom2 = "MARZO";
                break;
            case 3:nom2 = "ABRIL";
                break;
            case 4:nom2 = "MAYO";
                break;
            case 5:nom2 = "JUNIO";
                break;
            case 6:nom2 = "JULIO";
                break;
            case 7:nom2 = "AGOSTO";
                break;
            case 8:nom2 = "SEPTIEMBRE";
                break;
            case 9:nom2 = "OCTUBRE";
                break;
            case 10:nom2 = "NOVIEMBRE";
                break;
            case 11:nom2 = "DICIEMBRE";
                break;
        }
        mes_fecha2.setText(nom2);

    }



    private void GetDataday(int day)
    {
        postList1lunes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, "https://ctarequipa.net/bd_op/cond_horarioday.php?dni="+dni+"&day="+day+"", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Toast.makeText(HORARIOLABORAL.this,response.toString(), Toast.LENGTH_SHORT).show();
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        postList1lunes1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1lunes1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1lunes1.get(recyclerView1lunes1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1lunes1.get(recyclerView1lunes1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1lunes1.get(recyclerView1lunes1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1lunes1.get(recyclerView1lunes1.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1lunes1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        franco.clear();
                        franco.add(new PostModelFranco(
                                "Franco"
                        ));
                        adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                        recyclerView1lunes1.setAdapter(adapterFranco);
                        adapterFranco.notifyDataSetChanged();
                    }
                });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }









        private void GetData1lunes1()
    {
        postList1lunes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1lunes1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Toast.makeText(HORARIOLABORAL.this,response.toString(), Toast.LENGTH_SHORT).show();
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        postList1lunes1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1lunes1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1lunes1.get(recyclerView1lunes1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1lunes1.get(recyclerView1lunes1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1lunes1.get(recyclerView1lunes1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1lunes1.get(recyclerView1lunes1.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1lunes1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        franco.clear();
                        franco.add(new PostModelFranco(
                                "Franco"
                        ));
                        adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                        recyclerView1lunes1.setAdapter(adapterFranco);
                        adapterFranco.notifyDataSetChanged();
                    }
                });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }



    private void GetData1lunes2()
    {
        postList1lunes2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1lunes2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1lunes2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1lunes2);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1lunes2.get(recyclerView1lunes2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1lunes2.get(recyclerView1lunes2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1lunes2.get(recyclerView1lunes2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1lunes2.get(recyclerView1lunes2.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1lunes2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1lunes2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1lunes3()
    {
        postList1lunes3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1lunes3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1lunes3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1lunes3);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1lunes3.get(recyclerView1lunes3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1lunes3.get(recyclerView1lunes3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1lunes3.get(recyclerView1lunes3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1lunes3.get(recyclerView1lunes3.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1lunes3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1lunes3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1lunes4()
    {
        postList1lunes4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1lunes4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1lunes4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1lunes4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1lunes4.get(recyclerView1lunes4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1lunes4.get(recyclerView1lunes4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1lunes4.get(recyclerView1lunes4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1lunes4.get(recyclerView1lunes4.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1lunes4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1lunes4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1lunes5()
    {
        postList1lunes5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1lunes5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1lunes5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1lunes5);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1lunes5.get(recyclerView1lunes5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1lunes5.get(recyclerView1lunes5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1lunes5.get(recyclerView1lunes5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1lunes5.get(recyclerView1lunes5.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1lunes5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1lunes5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1lunes6()
    {
        postList1lunes6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1lunes6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1lunes6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1lunes6);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1lunes6.get(recyclerView1lunes6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1lunes6.get(recyclerView1lunes6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1lunes6.get(recyclerView1lunes6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1lunes6.get(recyclerView1lunes6.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1lunes6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1lunes6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }




    private void GetData1martes1()
    {
        postList1martes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1martes1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1martes1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1martes1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1martes1.get(recyclerView1martes1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1martes1.get(recyclerView1martes1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1martes1.get(recyclerView1martes1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1martes1.get(recyclerView1martes1.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1martes1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1martes1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1martes2()
    {
        postList1martes2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1martes2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1martes2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1martes2);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1martes2.get(recyclerView1martes2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1martes2.get(recyclerView1martes2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1martes2.get(recyclerView1martes2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1martes2.get(recyclerView1martes2.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);;
                    }
                });
                recyclerView1martes2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1martes2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1martes3()
    {
        postList1martes3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1martes3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1martes3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1martes3);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1martes3.get(recyclerView1martes3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1martes3.get(recyclerView1martes3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1martes3.get(recyclerView1martes3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1martes3.get(recyclerView1martes3.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1martes3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1martes3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1martes4()
    {
        postList1martes4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1martes4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1martes4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1martes4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1martes4.get(recyclerView1martes4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1martes4.get(recyclerView1martes4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1martes4.get(recyclerView1martes4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1martes4.get(recyclerView1martes4.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1martes4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1martes4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1martes5()
    {
        postList1martes5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1martes5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1martes5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1martes5);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1martes5.get(recyclerView1martes2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1martes5.get(recyclerView1martes2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1martes5.get(recyclerView1martes2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1martes5.get(recyclerView1martes5.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1martes5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1martes5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1martes6()
    {
        postList1martes6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1martes6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1martes6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1martes6);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1martes6.get(recyclerView1martes6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1martes6.get(recyclerView1martes6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1martes6.get(recyclerView1martes6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1martes6.get(recyclerView1martes6.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1martes6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1martes6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1miercoles1()
    {
        postList1miercoles1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1miercoles1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1miercoles1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1miercoles1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1miercoles1.get(recyclerView1miercoles1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1miercoles1.get(recyclerView1miercoles1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1miercoles1.get(recyclerView1miercoles1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1miercoles1.get(recyclerView1miercoles1.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1miercoles1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1miercoles1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1miercoles2()
    {
        postList1miercoles2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1miercoles2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1miercoles2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1miercoles2);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1miercoles2.get(recyclerView1miercoles2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1miercoles2.get(recyclerView1miercoles2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1miercoles2.get(recyclerView1miercoles2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1miercoles2.get(recyclerView1miercoles2.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1miercoles2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1miercoles2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1miercoles3()
    {
        postList1miercoles3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1miercoles3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1miercoles3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1miercoles3);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1miercoles3.get(recyclerView1miercoles3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1miercoles3.get(recyclerView1miercoles3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1miercoles3.get(recyclerView1miercoles3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1miercoles3.get(recyclerView1miercoles3.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1miercoles3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1miercoles3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1miercoles4()
    {
        postList1miercoles4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1miercoles4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1miercoles4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1miercoles4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1miercoles4.get(recyclerView1miercoles4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1miercoles4.get(recyclerView1miercoles4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1miercoles4.get(recyclerView1miercoles4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1miercoles4.get(recyclerView1miercoles4.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1miercoles4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1miercoles4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1miercoles5()
    {
        postList1miercoles5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1miercoles5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1miercoles5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1miercoles5);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1miercoles5.get(recyclerView1miercoles5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1miercoles5.get(recyclerView1miercoles5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1miercoles5.get(recyclerView1miercoles5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1miercoles5.get(recyclerView1miercoles5.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1miercoles5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1miercoles5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1miercoles6()
    {
        postList1miercoles6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1miercoles6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1miercoles6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1miercoles6);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1miercoles6.get(recyclerView1miercoles6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1miercoles6.get(recyclerView1miercoles6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1miercoles6.get(recyclerView1miercoles6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1miercoles6.get(recyclerView1miercoles6.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1miercoles6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1miercoles6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1jueves1()
    {
        postList1jueves1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1jueves1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1jueves1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1jueves1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1jueves1.get(recyclerView1jueves1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1jueves1.get(recyclerView1jueves1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1jueves1.get(recyclerView1jueves1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1jueves1.get(recyclerView1jueves1.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1jueves1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1jueves1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1jueves2()
    {
        postList1jueves2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1jueves2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1jueves2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1jueves2);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1jueves2.get(recyclerView1jueves2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1jueves2.get(recyclerView1jueves2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1jueves2.get(recyclerView1jueves2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1jueves2.get(recyclerView1jueves2.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1jueves2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1jueves2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1jueves3()
    {
        postList1jueves3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1jueves3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1jueves3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1jueves3);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1jueves3.get(recyclerView1jueves3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1jueves3.get(recyclerView1jueves3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1jueves3.get(recyclerView1jueves3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1jueves3.get(recyclerView1jueves3.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1jueves3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1jueves3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1jueves4()
    {
        postList1jueves4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1jueves4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1jueves4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1jueves4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1jueves4.get(recyclerView1jueves4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1jueves4.get(recyclerView1jueves4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1jueves4.get(recyclerView1jueves4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1jueves4.get(recyclerView1jueves4.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1jueves4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1jueves4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1jueves5()
    {
        postList1jueves5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1jueves5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1jueves5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1jueves5);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1jueves5.get(recyclerView1jueves5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1jueves5.get(recyclerView1jueves5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1jueves5.get(recyclerView1jueves5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1jueves5.get(recyclerView1jueves5.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1jueves5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1jueves5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1jueves6()
    {
        postList1jueves6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1jueves6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1jueves6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1jueves6);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1jueves6.get(recyclerView1jueves6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1jueves6.get(recyclerView1jueves6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1jueves6.get(recyclerView1jueves6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1jueves6.get(recyclerView1jueves6.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1jueves3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1jueves6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1viernes1()
    {
        postList1viernes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1viernes1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1viernes1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1viernes1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1viernes1.get(recyclerView1viernes1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1viernes1.get(recyclerView1viernes1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1viernes1.get(recyclerView1viernes1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1viernes1.get(recyclerView1viernes1.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1viernes1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1viernes1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1viernes2()
    {
        postList1viernes2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1viernes2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1viernes2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1viernes2);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1viernes2.get(recyclerView1viernes2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1viernes2.get(recyclerView1viernes2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1viernes2.get(recyclerView1viernes2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1viernes2.get(recyclerView1viernes2.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1viernes2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1viernes2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1viernes3()
    {
        postList1viernes3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1viernes3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1viernes3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1viernes3);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1viernes3.get(recyclerView1viernes3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1viernes3.get(recyclerView1viernes3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1viernes3.get(recyclerView1viernes3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1viernes3.get(recyclerView1viernes3.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1viernes3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1viernes3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1viernes4()
    {
        postList1viernes4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1viernes4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1viernes4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1viernes4);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1viernes4.get(recyclerView1viernes4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1viernes4.get(recyclerView1viernes4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1viernes4.get(recyclerView1viernes4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1viernes4.get(recyclerView1viernes4.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1viernes4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1viernes4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1viernes5()
    {
        postList1viernes5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1viernes5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1viernes5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1viernes5);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1viernes5.get(recyclerView1viernes5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1viernes5.get(recyclerView1viernes5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1viernes5.get(recyclerView1viernes5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1viernes5.get(recyclerView1viernes5.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1viernes5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1viernes5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1viernes6()
    {
        postList1viernes6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1viernes6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1viernes6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1viernes6);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1viernes6.get(recyclerView1viernes6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1viernes6.get(recyclerView1viernes6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1viernes6.get(recyclerView1viernes6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1viernes6.get(recyclerView1viernes6.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1viernes6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1viernes6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1sabado1()
    {
        postList1sabado1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1sabado1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1sabado1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1sabado1);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1sabado1.get(recyclerView1sabado1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1sabado1.get(recyclerView1sabado1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1sabado1.get(recyclerView1sabado1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1sabado1.get(recyclerView1sabado1.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1sabado1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1sabado1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1sabado2()
    {
        postList1sabado2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1sabado2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1sabado2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1sabado2);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1sabado2.get(recyclerView1sabado2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1sabado2.get(recyclerView1sabado2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1sabado2.get(recyclerView1sabado2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1sabado2.get(recyclerView1sabado2.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1sabado2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1sabado2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1sabado3()
    {
        postList1sabado3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1sabado3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1sabado3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1sabado3);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1sabado3.get(recyclerView1sabado3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1sabado3.get(recyclerView1sabado3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1sabado3.get(recyclerView1sabado3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1sabado3.get(recyclerView1sabado3.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1sabado3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1sabado3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1sabado4()
    {
        postList1sabado4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1sabado4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1sabado4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1sabado4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1sabado4.get(recyclerView1sabado4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1sabado4.get(recyclerView1sabado4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1sabado4.get(recyclerView1sabado4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1sabado4.get(recyclerView1sabado4.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1sabado4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1sabado4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1sabado5()
    {
        postList1sabado5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1sabado5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1sabado5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1sabado5);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1sabado5.get(recyclerView1sabado5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1sabado5.get(recyclerView1sabado5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1sabado5.get(recyclerView1sabado5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1sabado5.get(recyclerView1sabado5.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1sabado5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1sabado5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1sabado6()
    {
        postList1sabado6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1sabado6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1sabado6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1sabado6);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1sabado6.get(recyclerView1sabado6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1sabado6.get(recyclerView1sabado6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1sabado6.get(recyclerView1sabado6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1sabado6.get(recyclerView1sabado6.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1sabado6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1sabado6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1domingo1()
    {
        postList1domingo1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1domingo1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1domingo1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1domingo1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1domingo1.get(recyclerView1domingo1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1domingo1.get(recyclerView1domingo1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1domingo1.get(recyclerView1domingo1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1domingo1.get(recyclerView1domingo1.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1domingo1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1domingo1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1domingo2()
    {
        postList1domingo2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1domingo2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1domingo2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1domingo2);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1domingo2.get(recyclerView1domingo2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1domingo2.get(recyclerView1domingo2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1domingo2.get(recyclerView1domingo2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1domingo2.get(recyclerView1domingo2.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1domingo2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1domingo2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1domingo3()
    {
        postList1domingo3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1domingo3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1domingo3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1domingo3);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1domingo3.get(recyclerView1domingo3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1domingo3.get(recyclerView1domingo3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1domingo3.get(recyclerView1domingo3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1domingo3.get(recyclerView1domingo3.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1domingo3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1domingo3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1domingo4()
    {
        postList1domingo4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1domingo4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1domingo4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1domingo4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1domingo4.get(recyclerView1domingo4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1domingo4.get(recyclerView1domingo4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1domingo4.get(recyclerView1domingo4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1domingo4.get(recyclerView1domingo4.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1domingo4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1domingo4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1domingo5()
    {
        postList1domingo5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1domingo5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1domingo5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1domingo5);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1domingo5.get(recyclerView1domingo5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1domingo5.get(recyclerView1domingo5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1domingo5.get(recyclerView1domingo5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1domingo5.get(recyclerView1domingo5.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1domingo5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1domingo5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData1domingo6()
    {
        postList1domingo6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url1domingo6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList1domingo6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList1domingo6);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList1domingo6.get(recyclerView1domingo6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList1domingo6.get(recyclerView1domingo6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList1domingo6.get(recyclerView1domingo6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList1domingo6.get(recyclerView1domingo6.getChildAdapterPosition(view)).getServicio(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView1domingo3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView1domingo6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2lunes1()
    {
        postList2lunes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2lunes1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2lunes1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2lunes1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2lunes1.get(recyclerView2lunes1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2lunes1.get(recyclerView2lunes1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2lunes1.get(recyclerView2lunes1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2lunes1.get(recyclerView2lunes1.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2lunes1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2lunes1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2lunes2()
    {
        postList2lunes2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2lunes2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2lunes2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2lunes2);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2lunes2.get(recyclerView2lunes2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2lunes2.get(recyclerView2lunes2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2lunes2.get(recyclerView2lunes2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2lunes2.get(recyclerView2lunes2.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2lunes2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2lunes2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2lunes3()
    {
        postList2lunes3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2lunes3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2lunes3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2lunes3);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2lunes3.get(recyclerView2lunes3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2lunes3.get(recyclerView2lunes3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2lunes3.get(recyclerView2lunes3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2lunes3.get(recyclerView2lunes3.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2lunes3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2lunes3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2lunes4()
    {
        postList2lunes4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2lunes4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2lunes4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2lunes4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2lunes4.get(recyclerView2lunes4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2lunes4.get(recyclerView2lunes4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2lunes4.get(recyclerView2lunes4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2lunes4.get(recyclerView2lunes4.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2lunes4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2lunes4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2lunes5()
    {
        postList2lunes5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2lunes5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2lunes5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2lunes5);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2lunes5.get(recyclerView2lunes5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2lunes5.get(recyclerView2lunes5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2lunes5.get(recyclerView2lunes5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2lunes5.get(recyclerView2lunes5.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2lunes5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2lunes5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2lunes6()
    {
        postList2lunes6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2lunes6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2lunes6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2lunes6);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2lunes6.get(recyclerView2lunes6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2lunes6.get(recyclerView2lunes6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2lunes6.get(recyclerView2lunes6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2lunes6.get(recyclerView2lunes6.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2lunes6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2lunes6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2martes1()
    {
        postList2martes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2martes1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2martes1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2martes1);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2martes1.get(recyclerView2martes1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2martes1.get(recyclerView2martes1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2martes1.get(recyclerView2martes1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2martes1.get(recyclerView2martes1.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2martes1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2martes1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2martes2()
    {
        postList2martes2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2martes2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2martes2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2martes2);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2martes2.get(recyclerView1martes2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2martes2.get(recyclerView2martes2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2martes2.get(recyclerView2martes2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2martes2.get(recyclerView2martes2.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2martes2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2martes2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2martes3()
    {
        postList2martes3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2martes3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2martes3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2martes3);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2martes3.get(recyclerView1martes2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2martes3.get(recyclerView2martes3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2martes3.get(recyclerView2martes3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2martes3.get(recyclerView2martes3.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2martes3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2martes3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2martes4()
    {
        postList2martes4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2martes4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2martes4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2martes4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2martes4.get(recyclerView2martes4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2martes4.get(recyclerView2martes4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2martes4.get(recyclerView2martes4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2martes4.get(recyclerView2martes4.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2martes4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2martes4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2martes5()
    {
        postList2martes5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2martes5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2martes5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2martes5);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2martes5.get(recyclerView2martes5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2martes5.get(recyclerView2martes5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2martes5.get(recyclerView1martes2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2martes5.get(recyclerView2martes5.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2martes5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2martes5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2martes6()
    {
        postList2martes6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2martes6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2martes6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2martes6);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2martes6.get(recyclerView2martes6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2martes6.get(recyclerView2martes6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2martes6.get(recyclerView2martes6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2martes6.get(recyclerView2martes6.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2martes6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2martes6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2miercoles1()
    {
        postList2miercoles1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2miercoles1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2miercoles1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2miercoles1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2miercoles1.get(recyclerView2miercoles1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2miercoles1.get(recyclerView2miercoles1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2miercoles1.get(recyclerView2miercoles1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2miercoles1.get(recyclerView2miercoles1.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2miercoles1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2miercoles1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2miercoles2()
    {
        postList2miercoles2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2miercoles2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2miercoles2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2miercoles2);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2miercoles2.get(recyclerView1martes2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2miercoles2.get(recyclerView1martes2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2miercoles2.get(recyclerView2miercoles2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2miercoles2.get(recyclerView2miercoles2.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2miercoles2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2miercoles2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2miercoles3()
    {
        postList2miercoles3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2miercoles3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2miercoles3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2miercoles3);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2miercoles3.get(recyclerView2miercoles3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2miercoles3.get(recyclerView2miercoles3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2miercoles3.get(recyclerView2miercoles3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2miercoles3.get(recyclerView2miercoles3.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2miercoles3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2miercoles3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2miercoles4()
    {
        postList2miercoles4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2miercoles4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2miercoles4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2miercoles4);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2miercoles4.get(recyclerView2miercoles4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2miercoles4.get(recyclerView2miercoles4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2miercoles4.get(recyclerView2miercoles4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2miercoles4.get(recyclerView2miercoles4.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2miercoles4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2miercoles4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2miercoles5()
    {
        postList2miercoles5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2miercoles5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2miercoles5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2miercoles5);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2miercoles5.get(recyclerView2miercoles5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2miercoles5.get(recyclerView2miercoles5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2miercoles5.get(recyclerView2miercoles5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2miercoles5.get(recyclerView2miercoles5.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2miercoles5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2miercoles5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2miercoles6()
    {
        postList2miercoles6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2miercoles6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2miercoles6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2miercoles6);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2miercoles6.get(recyclerView2miercoles6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2miercoles6.get(recyclerView2miercoles6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2miercoles6.get(recyclerView2miercoles6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2miercoles6.get(recyclerView2miercoles6.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2miercoles6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2miercoles6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2jueves1()
    {
        postList2jueves1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2jueves1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2jueves1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2jueves1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2jueves1.get(recyclerView2jueves1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2jueves1.get(recyclerView2jueves1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2jueves1.get(recyclerView2jueves1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2jueves1.get(recyclerView2jueves1.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2jueves1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2jueves1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2jueves2()
    {
        postList2jueves2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2jueves2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2jueves2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2jueves2);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2jueves2.get(recyclerView2jueves2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2jueves2.get(recyclerView2jueves2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2jueves2.get(recyclerView2jueves2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2jueves2.get(recyclerView2jueves2.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2jueves2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2jueves2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2jueves3()
    {
        postList2jueves3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2jueves3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2jueves3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2jueves3);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2jueves3.get(recyclerView2jueves3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2jueves3.get(recyclerView2jueves3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2jueves3.get(recyclerView2jueves3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2jueves3.get(recyclerView2jueves3.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2jueves3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2jueves3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2jueves4()
    {
        postList2jueves4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2jueves4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2jueves4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2jueves4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2jueves4.get(recyclerView2jueves4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2jueves4.get(recyclerView2jueves4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2jueves4.get(recyclerView2jueves4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2jueves4.get(recyclerView2jueves4.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2jueves4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2jueves4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2jueves5()
    {
        postList2jueves5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2jueves5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2jueves5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2jueves5);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2jueves5.get(recyclerView2jueves5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2jueves5.get(recyclerView2jueves5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2jueves5.get(recyclerView2jueves5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2jueves5.get(recyclerView2jueves5.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2jueves5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2jueves5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2jueves6()
    {
        postList2jueves6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2jueves6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2jueves6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2jueves6);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2jueves6.get(recyclerView2jueves6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2jueves6.get(recyclerView2jueves6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2jueves6.get(recyclerView2jueves6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2jueves6.get(recyclerView2jueves6.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2jueves6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2jueves6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2viernes1()
    {
        postList2viernes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2viernes1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2viernes1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2viernes1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2viernes1.get(recyclerView2viernes1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2viernes1.get(recyclerView2viernes1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2viernes1.get(recyclerView2viernes1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2viernes1.get(recyclerView2viernes1.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2viernes1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2viernes1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2viernes2()
    {
        postList2viernes2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2viernes2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2viernes2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2viernes2);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2viernes2.get(recyclerView2viernes2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2viernes2.get(recyclerView2viernes2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2viernes2.get(recyclerView2viernes2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2viernes2.get(recyclerView2viernes2.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2viernes2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2viernes2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2viernes3()
    {
        postList2viernes3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2viernes3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2viernes3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2viernes3);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2viernes3.get(recyclerView2viernes3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2viernes3.get(recyclerView2viernes3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2viernes3.get(recyclerView2viernes3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2viernes3.get(recyclerView2viernes3.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2viernes3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2viernes3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        requestQueue.add(jsonArrayRequest);

    }


    private void GetData2viernes4()
    {
        postList2viernes4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2viernes4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2viernes4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2viernes4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2viernes4.get(recyclerView2viernes4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2viernes4.get(recyclerView2viernes4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2viernes4.get(recyclerView2viernes4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2viernes4.get(recyclerView2viernes4.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2viernes4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2viernes4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2viernes5()
    {
        postList2viernes5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2viernes5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2viernes5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2viernes5);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2viernes5.get(recyclerView2viernes5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2viernes5.get(recyclerView2viernes5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2viernes5.get(recyclerView2viernes5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2viernes5.get(recyclerView2viernes5.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2viernes5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2viernes5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2viernes6()
    {
        postList2viernes6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2viernes6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2viernes6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2viernes6);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2viernes6.get(recyclerView2viernes6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2viernes6.get(recyclerView2viernes6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2viernes6.get(recyclerView2viernes6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2viernes6.get(recyclerView2viernes6.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2viernes6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2viernes6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        requestQueue.add(jsonArrayRequest);

    }


    private void GetData2sabado1()
    {
        postList2sabado1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2sabado1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2sabado1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2sabado1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2sabado1.get(recyclerView2sabado1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2sabado1.get(recyclerView2sabado1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2sabado1.get(recyclerView2sabado1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2sabado1.get(recyclerView2sabado1.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2sabado1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2sabado1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2sabado2()
    {
        postList2sabado2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2sabado2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2sabado2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2sabado2);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2sabado2.get(recyclerView2sabado2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2sabado2.get(recyclerView2sabado2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2sabado2.get(recyclerView2sabado2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2sabado2.get(recyclerView2sabado2.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2sabado2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2sabado2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2sabado3()
    {
        postList2sabado3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2sabado3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2sabado3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2sabado3);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2sabado3.get(recyclerView2sabado3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2sabado3.get(recyclerView2sabado3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2sabado3.get(recyclerView2sabado3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2sabado3.get(recyclerView2sabado3.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2sabado3.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2sabado3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2sabado4()
    {
        postList2sabado4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2sabado4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2sabado4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2sabado4);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2sabado4.get(recyclerView2sabado4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2sabado4.get(recyclerView2sabado4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2sabado4.get(recyclerView2sabado4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2sabado4.get(recyclerView2sabado4.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2sabado4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2sabado4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2sabado5()
    {
        postList2sabado5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2sabado5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2sabado5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2sabado5);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2sabado5.get(recyclerView2sabado5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2sabado5.get(recyclerView2sabado5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2sabado5.get(recyclerView2sabado5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2sabado5.get(recyclerView2sabado5.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2sabado5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2sabado5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2sabado6()
    {
        postList2sabado6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2sabado6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2sabado6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2sabado6);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2sabado6.get(recyclerView2sabado6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2sabado6.get(recyclerView2sabado6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2sabado6.get(recyclerView2sabado6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2sabado6.get(recyclerView2sabado6.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2sabado6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2sabado6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2domingo1()
    {
        postList2domingo1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2domingo1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2domingo1.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2domingo1);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2domingo1.get(recyclerView2domingo1.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2domingo1.get(recyclerView2domingo1.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2domingo1.get(recyclerView2domingo1.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2domingo1.get(recyclerView2domingo1.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2domingo1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2domingo1.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2domingo2()
    {
        postList2domingo2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2domingo2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2domingo2.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2domingo2);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2domingo2.get(recyclerView2domingo2.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2domingo2.get(recyclerView2domingo2.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2domingo2.get(recyclerView2domingo2.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2domingo2.get(recyclerView2domingo2.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2domingo2.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2domingo2.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2domingo3()
    {
        postList2domingo3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2domingo3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2domingo3.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2domingo3);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2domingo3.get(recyclerView2domingo3.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2domingo3.get(recyclerView2domingo3.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2domingo3.get(recyclerView2domingo3.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2domingo3.get(recyclerView2domingo3.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2domingo3.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2domingo3.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2domingo4()
    {
        postList2domingo4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2domingo4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2domingo4.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2domingo4);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2domingo4.get(recyclerView2domingo4.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2domingo4.get(recyclerView2domingo4.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2domingo4.get(recyclerView2domingo4.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2domingo4.get(recyclerView2domingo4.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2domingo4.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2domingo4.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2domingo5()
    {
        postList2domingo5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2domingo5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2domingo5.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2domingo5);
                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2domingo5.get(recyclerView2domingo5.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2domingo5.get(recyclerView2domingo5.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2domingo5.get(recyclerView2domingo5.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2domingo5.get(recyclerView2domingo5.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2domingo5.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2domingo5.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData2domingo6()
    {
        postList2domingo6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url2domingo6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList2domingo6.add(new PostModel(
                                jsonObject.getString("fecha"),
                                jsonObject.getString("lugar_inicio"),
                                jsonObject.getString("lugar_fin"),
                                jsonObject.getString("hora_asist_cond"),
                                jsonObject.getString("hora_fin_prog"),
                                jsonObject.getString("servicio"),
                                jsonObject.getString("tipo_dia")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new PostAdapter(getApplicationContext(), postList2domingo6);

                adapter.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dato_servicio = "";
                        dato_servicio = postList2domingo6.get(recyclerView2domingo6.getChildAdapterPosition(view)).getServicio();
                        dato_fecha = "";
                        dato_fecha = postList2domingo6.get(recyclerView2domingo6.getChildAdapterPosition(view)).getFecha();
                        dato_tipo_dia = "";
                        dato_tipo_dia = postList2domingo6.get(recyclerView2domingo6.getChildAdapterPosition(view)).getTipo_dia();
                        Toast.makeText(getApplicationContext(), "Id: "+ postList2domingo6.get(recyclerView2domingo6.getChildAdapterPosition(view)).getFecha(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, DETALLEhorariolaboral.class);
                        intent.putExtra("dato_servicio",dato_servicio);
                        intent.putExtra("dato_fecha",dato_fecha);
                        intent.putExtra("dato_tipo_dia",dato_tipo_dia);
                        startActivity(intent);
                    }
                });
                recyclerView2domingo6.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                franco.clear();
                franco.add(new PostModelFranco(
                        "Franco"
                ));
                adapterFranco=new PostAdapterFranco(getApplicationContext(), franco);
                recyclerView2domingo6.setAdapter(adapterFranco);
                adapterFranco.notifyDataSetChanged();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }



    private void GetData3lunes1()
    {
        postList3lunes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3lunes1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3lunes1.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3lunes1);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3lunes1.get(recyclerView3lunes1.getChildAdapterPosition(view)).getId();
                        //Toast.makeText(getApplicationContext(), "Id: "+ postList3lunes1.get(recyclerView3lunes1.getChildAdapterPosition(view)).getHoralaboradaprog(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);

                        startActivity(intent);
                    }
                });
                recyclerView3lunes1.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3lunes2()
    {
        postList3lunes2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3lunes2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3lunes2.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3lunes2);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3lunes2.get(recyclerView3lunes2.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3lunes2.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3lunes3()
    {
        postList3lunes3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3lunes3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3lunes3.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3lunes3);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3lunes3.get(recyclerView3lunes3.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3lunes3.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3lunes4()
    {
        postList3lunes4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3lunes4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3lunes4.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3lunes4);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3lunes4.get(recyclerView3lunes4.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3lunes4.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3lunes5()
    {
        postList3lunes5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3lunes5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3lunes5.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3lunes5);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3lunes5.get(recyclerView3lunes5.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3lunes5.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3lunes6()
    {
        postList3lunes6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3lunes6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3lunes6.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3lunes6);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3lunes6.get(recyclerView3lunes6.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3lunes6.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3martes1()
    {
        postList3martes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3martes1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3martes1.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3martes1);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3martes1.get(recyclerView3martes1.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3martes1.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3martes2()
    {
        postList3martes2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3martes2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3martes2.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3martes2);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3martes2.get(recyclerView3martes2.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3martes2.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3martes3()
    {
        postList3martes3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3martes3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3martes3.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3martes3);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3martes3.get(recyclerView3martes3.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3martes3.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3martes4()
    {
        postList3martes4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3martes4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3martes4.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3martes4);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3martes4.get(recyclerView3martes4.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3martes4.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3martes5()
    {
        postList3martes5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3martes5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3martes5.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3martes5);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3martes5.get(recyclerView3martes5.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3martes5.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3martes6()
    {
        postList3martes6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3martes6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3martes6.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3martes6);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3martes6.get(recyclerView3martes6.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3martes6.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3miercoles1()
    {
        postList3miercoles1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3miercoles1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3miercoles1.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3miercoles1);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3miercoles1.get(recyclerView3miercoles1.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3miercoles1.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3miercoles2()
    {
        postList3miercoles2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3miercoles2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3miercoles2.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3miercoles2);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3miercoles2.get(recyclerView3miercoles2.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3miercoles2.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3miercoles3()
    {
        postList3miercoles3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3miercoles3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3miercoles3.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3miercoles3);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3miercoles3.get(recyclerView3miercoles3.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3miercoles3.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3miercoles4()
    {
        postList3miercoles4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3miercoles4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3miercoles4.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3miercoles4);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3miercoles4.get(recyclerView3miercoles4.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3miercoles4.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3miercoles5()
    {
        postList3miercoles5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3miercoles5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3miercoles5.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3miercoles5);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3miercoles5.get(recyclerView3miercoles5.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3miercoles5.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3miercoles6()
    {
        postList3miercoles6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3miercoles6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3miercoles6.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3miercoles6);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3miercoles6.get(recyclerView3miercoles6.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3miercoles6.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3jueves1()
    {
        postList3jueves1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3jueves1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3jueves1.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3jueves1);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3jueves1.get(recyclerView3jueves1.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3jueves1.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3jueves2()
    {
        postList3jueves2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3jueves2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3jueves2.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3jueves2);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3jueves2.get(recyclerView3jueves2.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3jueves2.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3jueves3()
    {
        postList3jueves3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3jueves3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3jueves3.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3jueves3);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3jueves3.get(recyclerView3jueves3.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3jueves3.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3jueves4()
    {
        postList3jueves4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3jueves4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3jueves4.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3jueves4);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3jueves4.get(recyclerView3jueves4.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3jueves4.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3jueves5()
    {
        postList3jueves5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3jueves5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3jueves5.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3jueves5);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3jueves5.get(recyclerView3jueves5.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3jueves5.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3jueves6()
    {
        postList3jueves6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3jueves6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3jueves6.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3jueves6);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3jueves6.get(recyclerView3jueves6.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3jueves6.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3viernes1()
    {
        postList3viernes1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3viernes1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3viernes1.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3viernes1);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3viernes1.get(recyclerView3viernes1.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3viernes1.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3viernes2()
    {
        postList3viernes2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3viernes2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3viernes2.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3viernes2);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3viernes2.get(recyclerView3viernes2.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3viernes2.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3viernes3()
    {
        postList3viernes3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3viernes3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3viernes3.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3viernes3);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3viernes3.get(recyclerView3viernes3.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3viernes3.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3viernes4()
    {
        postList3viernes4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3viernes4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3viernes4.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3viernes4);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3viernes4.get(recyclerView3viernes4.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3viernes4.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3viernes5()
    {
        postList3viernes5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3viernes5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3viernes5.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3viernes5);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3viernes5.get(recyclerView3viernes5.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3viernes5.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3viernes6()
    {
        postList3viernes6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3viernes6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3viernes6.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3viernes6);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3viernes6.get(recyclerView3viernes6.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3viernes6.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3sabado1()
    {
        postList3sabado1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3sabado1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3sabado1.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3sabado1);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3sabado1.get(recyclerView3sabado1.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3sabado1.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3sabado2()
    {
        postList3sabado2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3sabado2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3sabado2.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3sabado2);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3sabado2.get(recyclerView3sabado2.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3sabado2.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3sabado3()
    {
        postList3sabado3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3sabado3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3sabado3.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3sabado3);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3sabado3.get(recyclerView3sabado3.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3sabado3.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3sabado4()
    {
        postList3sabado4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3sabado4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3sabado4.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3sabado4);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3sabado4.get(recyclerView3sabado4.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3sabado4.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3sabado5()
    {
        postList3sabado5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3sabado5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3sabado5.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3sabado5);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3sabado5.get(recyclerView3sabado5.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);

                        startActivity(intent);
                    }
                });
                recyclerView3sabado5.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3sabado6()
    {
        postList3sabado6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3sabado6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3sabado6.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3sabado6);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3sabado6.get(recyclerView3sabado6.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);
                        startActivity(intent);
                    }
                });
                recyclerView3sabado6.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3domingo1()
    {
        postList3domingo1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3domingo1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3domingo1.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3domingo1);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3domingo1.get(recyclerView3domingo1.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);

                        startActivity(intent);
                    }
                });
                recyclerView3domingo1.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3domingo2()
    {
        postList3domingo2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3domingo2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3domingo2.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3domingo2);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3domingo2.get(recyclerView3domingo2.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);

                        startActivity(intent);
                    }
                });
                recyclerView3domingo2.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3domingo3()
    {
        postList3domingo3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3domingo3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3domingo3.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3domingo3);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3domingo3.get(recyclerView3domingo3.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);

                        startActivity(intent);
                    }
                });
                recyclerView3domingo3.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3domingo4()
    {
        postList3domingo4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3domingo4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3domingo4.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3domingo4);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3domingo4.get(recyclerView3domingo4.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);

                        startActivity(intent);
                    }
                });
                recyclerView3domingo4.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3domingo5()
    {
        postList3domingo5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3domingo5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        postList3domingo5.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3domingo5);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3domingo5.get(recyclerView3domingo5.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);

                        startActivity(intent);
                    }
                });
                recyclerView3domingo5.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3domingo6()
    {
        postList3domingo6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3domingo6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responsehora) {
                for(int i=0;i<=responsehora.length();i++){
                    try {
                        JSONObject jsonObject =responsehora.getJSONObject(i);
                        postList3domingo6.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3domingo6);
                adapterhora.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        id = "";
                        id = postList3domingo6.get(recyclerView3domingo6.getChildAdapterPosition(view)).getId();
                        Intent intent=new Intent(HORARIOLABORAL.this, HORAhorariolaboral.class);
                        intent.putExtra("hora_id",id);

                        startActivity(intent);
                    }
                });
                recyclerView3domingo6.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3semana1()
    {
        postList3semana1.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3semana1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responsehora) {
                for(int i=0;i<=responsehora.length();i++){
                    try {
                        JSONObject jsonObject =responsehora.getJSONObject(i);
                        postList3semana1.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3semana1);
                recyclerView3semana1.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3semana2()
    {
        postList3semana2.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3semana2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responsehora) {
                for(int i=0;i<=responsehora.length();i++){
                    try {
                        JSONObject jsonObject =responsehora.getJSONObject(i);
                        postList3semana2.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3semana2);
                recyclerView3semana2.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3semana3()
    {
        postList3semana3.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3semana3, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responsehora) {
                for(int i=0;i<=responsehora.length();i++){
                    try {
                        JSONObject jsonObject =responsehora.getJSONObject(i);
                        postList3semana3.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3semana3);
                recyclerView3semana3.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3semana4()
    {
        postList3semana4.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3semana4, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responsehora) {
                for(int i=0;i<=responsehora.length();i++){
                    try {
                        JSONObject jsonObject =responsehora.getJSONObject(i);
                        postList3semana4.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3semana4);
                recyclerView3semana4.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3semana5()
    {
        postList3semana5.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3semana5, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responsehora) {
                for(int i=0;i<=responsehora.length();i++){
                    try {
                        JSONObject jsonObject =responsehora.getJSONObject(i);
                        postList3semana5.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3semana5);
                recyclerView3semana5.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }


    private void GetData3semana6()
    {
        postList3semana6.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url3semana6, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responsehora) {
                for(int i=0;i<=responsehora.length();i++){
                    try {
                        JSONObject jsonObject =responsehora.getJSONObject(i);
                        postList3semana6.add(new HoraModel(
                                jsonObject.getString("horalaboradaprog"),
                                jsonObject.getString("horalaboradareal"),
                                jsonObject.getString("horalaboradatotal"),
                                jsonObject.getString("hora_id")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapterhora =new HoraAdapter(getApplicationContext(), postList3semana6);
                recyclerView3semana6.setAdapter(adapterhora);
                adapterhora.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);
    }




    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


}




