package lab3;
import lab2.Student;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class lab3ex2 {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("studenti_in.txt"));
            List<Student> studenti = new ArrayList<>();

            for (String line : lines) {
                String[] parts = line.split(",");

                Student s = new Student(
                        parts[0],
                        parts[1],
                        parts[2],
                        parts[3]
                );

                studenti.add(s);
            }

            for (Student s : studenti) {
                System.out.println(s);
            }

            // 3.5.2 sort dupa nume
            studenti.sort(Comparator.comparing(s -> s.nume));

            List<String> output = new ArrayList<>();
            for (Student s : studenti) {
                output.add(s.toString());
            }

            Files.write(Paths.get("studenti_out.txt"), output);

            //3.5.3 tema
            studenti.sort(
                    Comparator.comparing((Student s) -> s.formatieDeStudiu)
                            .thenComparing(s -> s.nume)
            );

            List<String> output2 = new ArrayList<>();
            for (Student s : studenti) {
                output2.add(s.toString());
            }

            Files.write(Paths.get("studenti_out_sorted.txt"), output2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}