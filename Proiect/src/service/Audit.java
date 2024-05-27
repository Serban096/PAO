package service;

import persistence.AmbulantaRepository;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Audit {
    static private Audit instance = null;
    static PrintWriter pw;

    public Audit(){
        try {
            pw = new PrintWriter(new FileOutputStream(new File("./Proiect/Audit.csv"), true));
            pw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Audit getInstance() {
        if (instance == null) {
            instance = new Audit();
        }

        return instance;
    }

    public static void write(String Message) {
        StringBuilder csvRow = new StringBuilder();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        csvRow.append(Message).append(",").append(dtf.format(now));
        pw.println(csvRow);
        pw.flush();
    }

}
