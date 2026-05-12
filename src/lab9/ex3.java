package lab9;
import lab2.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ex3 {

    public static void main(String[] args) {
        //exercitiul 9.3.3
        List<Student> studentiCuNote = Arrays.asList(
                new Student("1025", "Andrei", "Popa", "ISM141/2", 8.70),
                new Student("1024", "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student("1026", "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student("1029", "Bianca", "Popescu", "TI131/1,", 10),
                new Student("1029", "Maria", "Pana", "TI131/2,", 4.10),
                new Student("1029", "Gabriela", "Mohanu", "TI131/2,", 7.33),
                new Student("1029", "Marius", "Nasta", "TI131/2,", 3.20),
                new Student("1029", "Marius", "Nasta", "TI131/1,", 5.12),
                new Student("1029", "Andrei", "Dobrescu", "TI131/2,", 2.22)
        );

        //a) studentii cu 10
        System.out.println("--Nota10--");
        studentiCuNote.stream().filter(student -> student.getNota() == 10).forEach(System.out::println);

        //b) studentii cu nota mai mica de 5
        System.out.println("--Nota5--");
        studentiCuNote.stream().filter(student -> student.getNota() < 5).forEach(System.out::println);

        //c)mapping nota 4 devine 4
        List<Student> corectati = studentiCuNote.stream()
                .map(student -> {
                    if (student.getNota() < 4) student.setNota(4.0);
                    return student;
                }).collect(Collectors.toList());
        System.out.println("---Dupa mapping---");
        corectati.forEach(System.out::println);
        //d)suma
        double suma=studentiCuNote.stream().mapToDouble(student -> student.getNota()).sum();
        System.out.println("Suma note: "+suma);

        //e)Media
        double media=suma/studentiCuNote.size();
        System.out.println("Media: "+media);

    }
}