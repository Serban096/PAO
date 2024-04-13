package model.tratament;

public class TratamentFizioterapie extends Tratament{
    private int nr_sedinte;
    private int durata_sedinta;
    public TratamentFizioterapie(int tratament_id, String nume, int durata, int cost,
                                 int nr_sedinte, int durata_sedinta) {
        super(tratament_id, nume, durata, cost);
        this.nr_sedinte = nr_sedinte;
        this.durata_sedinta = durata_sedinta;
    }
}
