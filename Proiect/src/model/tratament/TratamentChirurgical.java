package model.tratament;

public class TratamentChirurgical extends Tratament{
    private String nume_operatie;
    private int rata_succes;
    public TratamentChirurgical(int tratament_id, String nume, int durata, int cost,
                                 String nume_operatie, int rata_succes) {
        super(tratament_id, nume, durata, cost);
        this.nume_operatie = nume_operatie;
        this.rata_succes = rata_succes;
    }
}
