package com.cta.conductor.menu.info_sugerencia;

public class SugeModel {

    String Fecha,Tipo,Area,Informe,Estado;

    public SugeModel(String fecha, String tipo, String area, String informe, String estado) {
        Fecha = fecha;
        Tipo = tipo;
        Area = area;
        Informe = informe;
        Estado = estado;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getInforme() {
        return Informe;
    }

    public void setInforme(String informe) {
        Informe = informe;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
