import model.Medic;
import model.tratament.Tratament;
import persistence.MedicRepository;
import persistence.TratamentRepository;
import service.DBConnection;
import view.ConsoleApp;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConsoleApp consoleApp = ConsoleApp.getInstance();
        consoleApp.start();
    }
}