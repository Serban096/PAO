package model;

public class Medic {
    private int medic_id;
    private String nume;
    private int varsta;
    private String specializare;
    private int salariu;
    private String numar_telefon;

    public Medic(){};
    public Medic(int medic_id, String nume, int varsta, String specializare, int salariu, String numar_telefon){
        this.medic_id = medic_id;
        this.nume = nume;
        this.varsta = varsta;
        this.specializare = specializare;
        this.salariu = salariu;
        this.numar_telefon = numar_telefon;
    }

    public int getMedic_id() {
        return medic_id;
    }

    public void setMedic_id(int medic_id) {
        this.medic_id = medic_id;
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

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public String getNr_telefon() {
        return numar_telefon;
    }

    public void setNr_telefon(String numar_telefon) {
        this.numar_telefon = numar_telefon;
    }
}
