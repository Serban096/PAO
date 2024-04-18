package main.java.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvPrintPerson {

    private static final String SEPARATOR = ",";

    public static void main(String[] args) {
        List<Person> dataLines = buildSampleData();
        writeUsingPrintPerson(dataLines);
    }

    private static List<Person> buildSampleData() {
        List<Person> sampleDataLines = new ArrayList<>();
        sampleDataLines.add(new Person("Marcel", "Ionescu", 38, "email_marcel@abc.com"));
        sampleDataLines.add(new Person("Sorin", "Popescu", 19, "email_sorin@def.com"));
        return sampleDataLines;
    }

    private static void writeUsingPrintPerson(List<Person> dataLines) {
        try (PrintWriter pw = new PrintWriter(new File("./lab8/csv_PrintPerson_output.csv"))) {
            for (Person line : dataLines) {
                String csvLine = transformToCSV(line);
                pw.println(csvLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String transformToCSV(Person data) {
        StringBuilder csvRow = new StringBuilder();
        csvRow.append(data.getNume()).append(SEPARATOR);
        csvRow.append(data.getPrenume()).append(SEPARATOR);
        csvRow.append(String.valueOf(data.getVarsta())).append(SEPARATOR);
        csvRow.append(data.getEmail());
        return csvRow.toString();
    }
}
