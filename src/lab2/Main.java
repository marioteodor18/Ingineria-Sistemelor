package lab2;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.*;

public class Main {

    public static boolean existaInLista(List<Student> lista, Student cautat) {
        for (Student s : lista) {
            if (s.getPrenume().equals(cautat.getPrenume()) &&
                    s.getNume().equals(cautat.getNume()) &&
                    s.getFormatieDeStudiu().equals(cautat.getFormatieDeStudiu())) {
                return true;
            }
        }
        return false;
    }

    public static boolean existaInSet(HashSet<Student> set, Student cautat) {
        return set.contains(cautat);
    }

    public static void main(String[] args) throws Exception {
        // lab5
        List<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursier("1025", "Andrei",   "Popa",     "ISM141/2",  8.70, 725.50));
        bursieri.add(new StudentBursier("1024", "Ioan",     "Mihalcea", "ISM141/1",  9.80, 801.10));
        bursieri.add(new StudentBursier("1026", "Anamaria", "Prodan",   "TI131/1",   8.90, 745.50));
        bursieri.add(new StudentBursier("1029", "Bianca",   "Popescu",  "TI131/1",   9.10, 780.80));

        System.out.println("Lista bursieri");
        for (StudentBursier sb : bursieri) {
            System.out.println(sb);
        }

        FileUtils.saveToFile("bursieri_out.txt", bursieri);
        System.out.println("\nFinal Lab5");

        //  lab2
        Student student1 = new Student("594", "Mario",     "Roman",      "ISM 21/1");
        Student student2 = new Student("120", "Alis",      "Popa",       "TI21/2");
        Student student3 = new Student("112", "Maria",     "Popa",       "TI21/1");
        Student student4 = new Student("584", "Alexandru", "Dumitrescu", "ISM21/1");
        Student student5 = new Student("590", "Spanu",     "Mihai",      "ISM21/2");

        List<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(student1);
        listaStudenti.add(student2);
        listaStudenti.add(student3);
        listaStudenti.add(student4);
        listaStudenti.add(student5);

        for (Student s : listaStudenti) {
            System.out.println(s);
        }

        Student cautat1 = new Student("120", "Alis", "Popa", "TI21/2");
        System.out.println("Alis Popa este in lista: " + existaInLista(listaStudenti, cautat1));

        Student cautat2 = new Student("112", "Maria", "Popa", "TI21/1");
        System.out.println("Maria Popa este in lista: " + existaInLista(listaStudenti, cautat2));

        HashSet<Student> setStudenti = new HashSet<>(listaStudenti);
        System.out.println("Alis Popa este in set: " + existaInSet(setStudenti, cautat1));
        System.out.println("Maria Popa este in set: " + existaInSet(setStudenti, cautat2));

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++)
            x.add(random.nextInt(11));
        for (int i = 0; i < 7; i++)
            y.add(random.nextInt(11));

        Collections.sort(x);
        Collections.sort(y);
        System.out.println("lista x" + x);
        System.out.println("lista y" + y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("a) xPlusY: " + xPlusY);

        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("c) xMinusY " + xMinusY);

        Set<Integer> tempSet = new TreeSet<>();
        for (int val : x) {
            if (val <= p) tempSet.add(val);
        }
        for (int val : y) {
            if (val <= p) tempSet.add(val);
        }
        xPlusYLimitedByP.addAll(tempSet);
        System.out.println("d) xPlusYLimitedByP: " + xPlusYLimitedByP);

    }
}