package lab10;

import lab2.Student;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public  class StudentiInFisierText implements IStudentiExport {

    private final String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("numarMatricol,prenume,nume,formatieDeStudiu,nota");
            writer.newLine();
            for (Student s : studenti) {
                writer.write(String.format(s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), s.getNota()));
                writer.newLine();
            }

            System.out.println("Export TXT reusit: " + fileName
                    + " (" + studenti.size() + " studenti)");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea fisierului text: " + e.getMessage());
        }
    }
}