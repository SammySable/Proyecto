package com.cta.conductor.menu.info_sugerencia.info_vacaciones;

public class VacacionesModel {

    String Fecha_solicitud, Tipovacaciones, Fecha_inicial, Fecha_final, Numero_dias, Estado_vac;


    public VacacionesModel(String fecha_solicitud, String tipovacaciones,
                           String fecha_inicial, String fecha_final,
                           String numero_dias, String estado_vac) {

        Fecha_solicitud = fecha_solicitud;
        Tipovacaciones = tipovacaciones;
        Fecha_inicial = fecha_inicial;
        Fecha_final = fecha_final;
        Numero_dias = numero_dias;
        Estado_vac = estado_vac;
    }

    public String getFecha_solicitud() {
        return Fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        Fecha_solicitud = fecha_solicitud;
    }

    public String getTipovacaciones() {
        return Tipovacaciones;
    }

    public void setTipovacaciones(String tipovacaciones) {
        Tipovacaciones = tipovacaciones;
    }

    public String getFecha_inicial() {
        return Fecha_inicial;
    }

    public void setFecha_inicial(String fecha_inicial) {
        Fecha_inicial = fecha_inicial;
    }

    public String getFecha_final() {
        return Fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        Fecha_final = fecha_final;
    }

    public String getNumero_dias() {
        return Numero_dias;
    }

    public void setNumero_dias(String numero_dias) {
        Numero_dias = numero_dias;
    }

    public String getEstado() {
        return Estado_vac;
    }

    public void setEstado(String estado_vac) {
        Estado_vac = estado_vac;
    }
}
