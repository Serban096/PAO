package model;

import java.util.ArrayList;

public class Ambulanta {
    private int ambulanta_id;
    private ArrayList<Pacient> pacienti;
    private ArrayList<Paramedic> paramedici;
    private String nr_inmatriculare;
    private int kilometraj;
    private int an_achizitie;
    private int an_revizie;
    public Ambulanta(int ambulanta_id, ArrayList<Pacient> pacienti, ArrayList<Paramedic> paramedici,
                     String nr_inmatriculare, int kilometraj, int an_achizitie, int an_revizie){
        this.ambulanta_id = ambulanta_id;
        this.pacienti = pacienti;
        this.paramedici = paramedici;
        this.nr_inmatriculare = nr_inmatriculare;
        this.kilometraj = kilometraj;
        this.an_achizitie = an_achizitie;
        this.an_revizie = an_revizie;
    }
}
