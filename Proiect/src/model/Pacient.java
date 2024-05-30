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

    public Pacient(){};
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

    public int getPacient_id() {
        return pacient_id;
    }

    public void setPacient_id(int pacient_id) {
        this.pacient_id = pacient_id;
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

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public String getGrupa_sange() {
        return grupa_sange;
    }

    public void setGrupa_sange(String grupa_sange) {
        this.grupa_sange = grupa_sange;
    }

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return STR."Pacient{pacient_id=\{pacient_id}, ambulanta_id=\{ambulanta_id}, nume='\{nume}\{'\''}, varsta=\{varsta}, greutate=\{greutate}, grupa_sange='\{grupa_sange}\{'\''}, cnp=\{cnp}}";
    }
}
