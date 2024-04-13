package model.asociative;

import model.Medic;

public class Medic_Trateaza_Pacient {
    private int medic_id;
    private int pacient_id;
    private int tratament_id;
    public Medic_Trateaza_Pacient(int medic_id, int pacient_id, int tratament_id){
        this.medic_id = medic_id;
        this.pacient_id = pacient_id;
        this.tratament_id = tratament_id;
    }
}
