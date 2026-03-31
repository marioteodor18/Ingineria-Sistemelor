package lab4;

import lab2.Student;

import java.io.File;
import java.util.*;

public class AppStudenti {
//exercitii laborator
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
//tema de casa
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

        // tema
        HashMap<String, Student> tineri = new HashMap<>();
        for (Student s : mapStudenti.values()) {
            String key = s.getPrenume() + "-" + s.getNume();
            tineri.put(key, s);
        }

        //  tema
        float notaB = gasesteNota("Bianca", "Popescu", tineri);
        float notaI = gasesteNota("Ioan", "Popa", tineri);

        System.out.println("Nota Bianca Popescu: " + notaB);
        System.out.println("Nota Ioan Popa: " + notaI);
    }

    // tema metoda
    public static float gasesteNota(String prenume, String nume, Map<String, Student> studenti) {
        String key = prenume + "-" + nume;
        if (studenti.containsKey(key)) {
            return (float) studenti.get(key).getNota();
        }
        return 0.0f;
    }
}

