package model.tratament;

import java.util.ArrayList;

public class TratamentMedicamentos extends Tratament{
    private String instructiuni;
    private ArrayList<String> efecte_secundare;

    public TratamentMedicamentos(int tratament_id, String nume, int durata, int pret,
                               String instructiuni, ArrayList<String> efecte_secundare) {
        super(tratament_id, nume, durata, pret);
        this.instructiuni = instructiuni;
        this.efecte_secundare = efecte_secundare;
    }
}
