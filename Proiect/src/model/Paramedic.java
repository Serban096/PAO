package model;

public class Paramedic {
    private int paramedic_id;
    private int ambulanta_id;
    private Ambulanta ambulanta;
    private String nume;
    private int varsta;
    private int salariu;
    public Paramedic(){};
    public Paramedic(int paramedic_id, int ambulanta_id, Ambulanta ambulanta, String nume, int varsta, int salariu){
        this.paramedic_id = paramedic_id;
        this.ambulanta_id = ambulanta_id;
        this.ambulanta = ambulanta;
        this.nume = nume;
        this.varsta = varsta;
        this.salariu = salariu;
    }

    public int getParamedic_id() {
        return paramedic_id;
    }

    public void setParamedic_id(int paramedic_id) {
        this.paramedic_id = paramedic_id;
    }

    public int getAmbulanta_id() {
        return ambulanta_id;
    }

    public void setAmbulanta_id(int ambulanta_id) {
        this.ambulanta_id = ambulanta_id;
    }

    public Ambulanta getAmbulanta() {
        return ambulanta;
    }

    public void setAmbulanta(Ambulanta ambulanta) {
        this.ambulanta = ambulanta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }
}
