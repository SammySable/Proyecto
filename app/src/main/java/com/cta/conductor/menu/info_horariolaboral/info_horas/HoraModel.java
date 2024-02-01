package com.cta.conductor.menu.info_horariolaboral.info_horas;

public class HoraModel {
    String Id;
    String Horalaboradaprog;
    String Horalaboradareal;
    String Horalaboradatotal;

    public HoraModel(String horalaboradaprog, String horalaboradareal,
                     String horalaboradatotal, String id) {
        Id = id;
        Horalaboradaprog = horalaboradaprog;
        Horalaboradareal = horalaboradareal;
        Horalaboradatotal = horalaboradatotal;
    }

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        this.Id = id;
    }

    public String getHoralaboradareal() {
        return Horalaboradareal;
    }
    public void setHoralaboradareal(String horalaboradareal) {
        this.Horalaboradareal = horalaboradareal;
    }

    public String getHoralaboradatotal() {
        return Horalaboradatotal;
    }
    public void setHoralaboradatotal(String horalaboradatotal) {
        this.Horalaboradatotal = horalaboradatotal;
    }

    public String getHoralaboradaprog() {
        return Horalaboradaprog;
    }
    public void setHoralaboradaprog(String horalaboradaprog) {
        Horalaboradaprog = horalaboradaprog;
    }

}

