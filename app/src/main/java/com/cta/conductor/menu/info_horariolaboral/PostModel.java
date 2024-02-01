package com.cta.conductor.menu.info_horariolaboral;

public class PostModel {
    int userId;
    String Fecha,Lugar_inicio,Lugar_fin,Hora_asist_cond,Hora_fin_prog, Servicio, Tipo_dia;



    public PostModel(String fecha, String lugar_inicio,
                     String lugar_fin, String hora_asist_cond,
                     String hora_fin_prog, String servicio,
                     String tipo_dia) {

        Fecha = fecha;
        Lugar_inicio = lugar_inicio;
        Lugar_fin = lugar_fin;
        Hora_asist_cond = hora_asist_cond;
        Hora_fin_prog = hora_fin_prog;
        Servicio = servicio;
        Tipo_dia = tipo_dia;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getLugar_inicio() {
        return Lugar_inicio;
    }

    public void setLugar_inicio(String lugar_inicio) {
        Lugar_inicio = lugar_inicio;
    }

    public String getLugar_fin() {
        return Lugar_fin;
    }

    public void setLugar_fin(String lugar_fin) {
        Lugar_fin = lugar_fin;
    }

    public String getHora_asist_cond() {
        return Hora_asist_cond;
    }

    public void setHora_asist_cond(String hora_asist_cond) {
        Hora_asist_cond = hora_asist_cond;
    }

    public String getHora_fin_prog() {
        return Hora_fin_prog;
    }

    public void setHora_salida_prog(String hora_fin_prog) {
        Hora_fin_prog = hora_fin_prog;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String sevicio) {
        Servicio = sevicio;
    }

    public String getTipo_dia() {
        return Tipo_dia;
    }

    public void setTipo_dia(String tipo_dia) {
        Tipo_dia = tipo_dia;
    }
}

