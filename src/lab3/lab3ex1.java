package lab3;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class lab3ex1 {
        public static void main(String[] args) {
            try {
                Path path = Paths.get("in.txt");
                List<String> lines = Files.readAllLines(path);

                List<String> rezultatA = new ArrayList<>();
                List<String> rezultatB = new ArrayList<>();

                // a
                for (String line : lines) {
                    String modified = line + "\n";
                    rezultatA.add(modified);
                    System.out.println(modified);
                }

                System.out.println("\n=== b) ===\n");

                // b
                for (String line : lines) {
                    String modified = line.replace(".", ".\n");
                    rezultatB.add(modified);
                    System.out.println(modified);
                }

                // c
                List<String> finalOutput = new ArrayList<>();
                finalOutput.addAll(rezultatA);
                finalOutput.addAll(rezultatB);

                Files.write(Paths.get("out.txt"), finalOutput);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }