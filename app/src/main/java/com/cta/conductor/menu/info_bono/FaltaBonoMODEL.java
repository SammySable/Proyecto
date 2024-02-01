package com.cta.conductor.menu.info_bono;

public class FaltaBonoMODEL {

    String Datos_fecha,Datos_evasion,Datos_video,Datos_cumplimiento;



    public FaltaBonoMODEL(String datos_fecha, String datos_evasion,
                          String datos_video, String datos_cumplimiento)
    {
        Datos_fecha = datos_fecha;
        Datos_cumplimiento = datos_cumplimiento;
        Datos_video = datos_video;
        Datos_evasion = datos_evasion;
    }

    public String getDatos_fecha() {
        return Datos_fecha;
    }
    public void setDatos_fecha(String datos_fecha) {
        Datos_fecha = datos_fecha;
    }

    public String getDatos_evasion() {
        return Datos_evasion;
    }
    public void setDatos_evasion(String datos_evasion) {
        Datos_evasion = datos_evasion;
    }

    public String getDatos_video() {
        return Datos_video;
    }
    public void setDatos_video(String datos_video) {
        Datos_video = datos_video;
    }


}
