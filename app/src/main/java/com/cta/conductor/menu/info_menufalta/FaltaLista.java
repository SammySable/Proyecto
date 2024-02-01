package com.cta.conductor.menu.info_menufalta;

public class FaltaLista {

    String Falta_Fecha,Falta_Tipo_PA,Falta_NivelFalta,Falta_Ocurrencia,Falta_Estado;

    public FaltaLista(String falta_fecha,String falta_tipo_pa,
                      String falta_nivelfalta,String falta_ocurrencia,
                      String falta_estado) {
        Falta_Fecha=falta_fecha;
        Falta_Tipo_PA = falta_tipo_pa;
        Falta_NivelFalta = falta_nivelfalta;
        Falta_Ocurrencia = falta_ocurrencia;
        Falta_Estado = falta_estado;
    }

    public String getFalta_Fecha() {
        return Falta_Fecha;
    }
    public void setFalta_Fecha(String falta_Fecha) {
        Falta_Fecha = falta_Fecha;
    }

    public String getFalta_Tipo_PA() {
        return Falta_Tipo_PA;
    }
    public void setFalta_Tipo_PA(String falta_Tipo_PA) {
        Falta_Tipo_PA = falta_Tipo_PA;
    }

    public String getFalta_NivelFalta() {
        return Falta_NivelFalta;
    }
    public void setFalta_NivelFalta(String falta_NivelFalta) {
        Falta_NivelFalta = falta_NivelFalta;
    }

    public String getFalta_Ocurrencia() {
        return Falta_Ocurrencia;
    }
    public void setFalta_Ocurrencia(String falta_Ocurrencia) {
        Falta_Ocurrencia = falta_Ocurrencia;
    }

    public String getFalta_Estado() {
        return Falta_Estado;
    }
    public void setFalta_Estado(String falta_Estado) {
        Falta_Estado = falta_Estado;
    }


}
