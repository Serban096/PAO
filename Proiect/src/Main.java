import model.Medic;
import model.tratament.Tratament;
import persistence.MedicRepository;
import persistence.TratamentRepository;
import service.DBConnection;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DBConnection d = DBConnection.getInstance();
//        TratamentRepository tr = TratamentRepository.getInstance();
//        Tratament t = new Tratament(3, "Serban Baesu", 22, 12000);
//        Tratament t2 = new Tratament(3, "ceva", 213, 120011);
//        tr.delete(t2);
////      System.out.println(tr.get(1).getNume());
//        ArrayList<Tratament> tratamente = tr.getAll();
//        for(Tratament x : tratamente)
//            System.out.println(x.getNume());
        MedicRepository mr = MedicRepository.getInstance();
        Medic m = new Medic(2, "Paul", 20, "altceva", 12000, "03919412");
        //mr.add(m);
        //Medic m2 = mr.get(1);
        //System.out.println(m2.getNume());
        //for(Medic x:mr.getAll())
        //    System.out.println(x.getNume());
        //mr.delete(m);
    }
}