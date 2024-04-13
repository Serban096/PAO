package model;

public class Pacient {
    private int pacient_id;
    private int ambulanta_id;
    private Ambulanta ambulanta;
    private String nume;
    private int varsta;
    private int greutate;
    private String grupa_sange;
    private long cnp;

    public Pacient(int pacient_id, int ambulanta_id, Ambulanta ambulanta, String nume, int varsta,
                   int greutate, String grupa_sange, long cnp){
        this.pacient_id = pacient_id;
        this.ambulanta_id = ambulanta_id;
        this.ambulanta = ambulanta;
        this.nume = nume;
        this.varsta = varsta;
        this.greutate = greutate;
        this.grupa_sange = grupa_sange;
        this.cnp = cnp;
    }
}
