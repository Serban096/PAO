package model.tratament;

public abstract class Tratament {
    private int tratament_id;
    private String nume;
    private int durata;
    private int cost;
    public Tratament(){ }
    public Tratament(int tratament_id, String nume, int durata, int cost){
        this.tratament_id = tratament_id;
        this.nume = nume;
        this.durata = durata;
        this.cost = cost;
    }
}
