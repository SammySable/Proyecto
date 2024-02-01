package com.cta.conductor.menu.info_horariolaboral.info_detallehorario;

public class DetalleModel {


    String Ftime;
    String Fnode;
    String Ttime;
    String Tnode;
    String Servicio;


    public DetalleModel(String ftime, String fnode, String ttime, String tnode, String servicio) {
        Ftime = ftime;
        Fnode = fnode;
        Ttime = ttime;
        Tnode = tnode;
        Servicio = servicio;
    }

    public String getFtime() {
        return Ftime;
    }

    public void setFtime(String ftime) {
        Ftime = ftime;
    }

    public String getFnode() {
        return Fnode;
    }

    public void setFnode(String fnode) {
        Fnode = fnode;
    }

    public String getTtime() {
        return Ttime;
    }

    public void setTtime(String ttime) {
        Ttime = ttime;
    }

    public String getTnode() {
        return Tnode;
    }

    public void setTnode(String tnode) {
        Tnode = tnode;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String servicio) {
        Servicio = servicio;
    }



}