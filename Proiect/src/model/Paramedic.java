package model;

public class Paramedic {
    private int paramedic_id;
    private int ambulanta_id;
    private Ambulanta ambulanta;
    private String nume;
    private int varsta;
    private int salariu;
    public Paramedic(int paramedic_id, int ambulanta_id, Ambulanta ambulanta, String nume, int varsta, int salariu){
        this.paramedic_id = paramedic_id;
        this.ambulanta_id = ambulanta_id;
        this.ambulanta = ambulanta;
        this.nume = nume;
        this.varsta = varsta;
        this.salariu = salariu;
    }
}
