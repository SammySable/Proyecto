package com.cta.conductor.menu.info_peticion;

public class PetiModel {

    String Fecha,Tipo,Motivo,Informe,Estado,Comentario;

    public PetiModel(String fecha, String tipo, String motivo, String informe, String estado, String comentario) {
        Fecha = fecha;
        Tipo = tipo;
        Motivo = motivo;
        Informe = informe;
        Estado = estado;
        Comentario = comentario;
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

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
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

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }
}
