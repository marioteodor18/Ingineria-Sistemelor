package lab8;

import lab2.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.*;
import java.util.*;

public class MainStudenti {

    public static void main(String[] args) throws Exception {
        // studentii din laboratorul trecut (lab7)

        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student("101", "Ion",   "Popescu",    "TI 211"));
        studenti.add(new Student("102", "Maria", "Ionescu",    "TI 211"));
        studenti.add(new Student("103", "Ana",   "Georgescu",  "TI 211"));
        studenti.add(new Student("104", "Radu",  "Dumitrescu", "TI 211"));
        studenti.add(new Student("105", "Elena", "Popa",       "TI 211"));

        // 8.5.4 a
        String xlsFileName = "laborator8_students.xlsx";
        writeToXls(studenti, xlsFileName);
        System.out.println("Generat: " + xlsFileName);

        // 8.5.4 b
        List<Student> studentsFromXls = readFromXls(xlsFileName);
        System.out.println("\nStudenti cititi din excel:");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }

    public static void writeToXls(Set<Student> studenti, String numeFisier) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Studenti");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("NumarMatricol");
        header.createCell(1).setCellValue("Prenume");
        header.createCell(2).setCellValue("Nume");
        header.createCell(3).setCellValue("FormatiDeStudiu");
        header.createCell(4).setCellValue("Nota");

        int numarRand = 1;
        for (Student st : studenti) {
            Row row = sheet.createRow(numarRand++);
            row.createCell(0).setCellValue(st.getNumarMatricol());
            row.createCell(1).setCellValue(st.getPrenume());
            row.createCell(2).setCellValue(st.getNume());
            row.createCell(3).setCellValue(st.getFormatieDeStudiu());
            row.createCell(4).setCellValue(st.getNota());
        }

        FileOutputStream fos = new FileOutputStream(numeFisier);
        wb.write(fos);
        fos.close();
        wb.close();
    }

    public static List<Student> readFromXls(String numeFisier) throws Exception {
        List<Student> studenti = new ArrayList<>();
        FileInputStream fis = new FileInputStream(numeFisier);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        boolean primaLinie = true;
        for (Row row : sheet) {
            if (primaLinie) {
                primaLinie = false;
                continue;
            }
            String numarMatricol= row.getCell(0).getStringCellValue();
            String prenume= row.getCell(1).getStringCellValue();
            String nume= row.getCell(2).getStringCellValue();
            String formatie= row.getCell(3).getStringCellValue();
            double nota= row.getCell(4).getNumericCellValue();

            Student st = new Student(numarMatricol, prenume, nume, formatie);
            st.setNota(nota);
            studenti.add(st);
        }

        wb.close();
        return studenti;
    }
}