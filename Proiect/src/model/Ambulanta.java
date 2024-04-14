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
    public Ambulanta(){};
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

    public int getAmbulanta_id() {
        return ambulanta_id;
    }

    public void setAmbulanta_id(int ambulanta_id) {
        this.ambulanta_id = ambulanta_id;
    }

    public ArrayList<Pacient> getPacienti() {
        return pacienti;
    }

    public void setPacienti(ArrayList<Pacient> pacienti) {
        this.pacienti = pacienti;
    }

    public ArrayList<Paramedic> getParamedici() {
        return paramedici;
    }

    public void setParamedici(ArrayList<Paramedic> paramedici) {
        this.paramedici = paramedici;
    }

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public int getKilometraj() {
        return kilometraj;
    }

    public void setKilometraj(int kilometraj) {
        this.kilometraj = kilometraj;
    }

    public int getAn_achizitie() {
        return an_achizitie;
    }

    public void setAn_achizitie(int an_achizitie) {
        this.an_achizitie = an_achizitie;
    }

    public int getAn_revizie() {
        return an_revizie;
    }

    public void setAn_revizie(int an_revizie) {
        this.an_revizie = an_revizie;
    }
}
