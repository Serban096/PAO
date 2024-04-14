package model.tratament;

public class Tratament {
    private int tratament_id;
    private String nume;
    private int durata;
    private int pret;
    public Tratament(){ }
    public Tratament(int tratament_id, String nume, int durata, int pret){
        this.tratament_id = tratament_id;
        this.nume = nume;
        this.durata = durata;
        this.pret = pret;
    }

    public int getTratament_id() {
        return tratament_id;
    }

    public String getNume() {
        return nume;
    }

    public int getDurata() {
        return durata;
    }

    public int getPret() {
        return pret;
    }

    public void setTratament_id(int tratament_id) {
        this.tratament_id = tratament_id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
}
