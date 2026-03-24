package lab4;

import lab2.Student;

import java.io.File;
import java.util.*;

public class AppStudenti {

    public static void main(String[] args) throws Exception {
        List<Student> listaStudenti = new ArrayList<>();
        Scanner sc = new Scanner(new File("studenti_in.txt"));

        while (sc.hasNextLine()) {
            String linie = sc.nextLine();
            String[] parts = linie.split(",");

            Student s = new Student(
                    parts[0],
                    parts[1],
                    parts[2],
                    parts[3]
            );

            listaStudenti.add(s);
        }
        sc.close();

        HashMap<String, Student> mapStudenti = new HashMap<>();

        for (Student s : listaStudenti) {
            mapStudenti.put(s.getNumarMatricol(), s);
        }


        Scanner scNote = new Scanner(new File("note_anon.txt"));

        while (scNote.hasNextLine()) {
            String linie = scNote.nextLine();
            String[] parts = linie.split(",");

            String nrMatricol = parts[0];
            double nota = Double.parseDouble(parts[1]);

            Student s = mapStudenti.get(nrMatricol);

            if (s != null) {
                s.setNota(nota);
            }
        }
        scNote.close();


        System.out.println(" Studenti cu note ");
        mapStudenti.forEach((k, v) -> System.out.println(v));


        float notaM = gasesteNota("Bianca", "Popescu", mapStudenti);
        float notaN = gasesteNota("Ioan", "Popa", mapStudenti);

        System.out.println("Nota Bianca: " + notaM);
        System.out.println("Nota Ioan: " + notaN);
    }


    public static float gasesteNota(String prenume, String nume,
                                    Map<String, Student> studenti) {

        for (Student s : studenti.values()) {
            if (s.getPrenume().equals(prenume) && s.getNume().equals(nume)) {
                return (float) s.getNota();
            }
        }
        return 0.0f;
    }

}