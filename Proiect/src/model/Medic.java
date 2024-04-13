package model;

public class Medic {
    private int medic_id;
    private String nume;
    private int varsta;
    private String specializare;
    private int salariu;
    private String nr_telefon;

    public Medic(int medic_id, String nume, int varsta, String specializare, int salariu, String nr_telefon){
        this.medic_id = medic_id;
        this.nume = nume;
        this.varsta = varsta;
        this.specializare = specializare;
        this.salariu = salariu;
        this.nr_telefon = nr_telefon;
    }
}
