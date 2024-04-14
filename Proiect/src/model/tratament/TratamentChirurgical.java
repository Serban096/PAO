package model.tratament;

public class TratamentChirurgical extends Tratament{
    private String nume_operatie;
    private int rata_succes;
    public TratamentChirurgical(){};
    public TratamentChirurgical(int tratament_id, String nume, int durata, int pret,
                                 String nume_operatie, int rata_succes) {
        super(tratament_id, nume, durata, pret);
        this.nume_operatie = nume_operatie;
        this.rata_succes = rata_succes;
    }
}
