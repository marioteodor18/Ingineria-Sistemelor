package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        citesteFisier("laborator8_input.xlsx");
        genereazaOutput2("laborator8_input.xlsx", "laborator8_output2.xlsx");
        genereazaOutput3("laborator8_input.xlsx", "laborator8_output3.xlsx");
    }

    // 8.5.1 citire si afisare in cons
    public static void citesteFisier(String numeFisier) throws Exception {
        FileInputStream fis = new FileInputStream(numeFisier);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        System.out.println("Continutul fisierului:");
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING) {
                    System.out.print(cell.getStringCellValue() + "\t");
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    System.out.print((int) cell.getNumericCellValue() + "\t");
                }
            }
            System.out.println();
        }
        workbook.close();
    }

    // 8.5.2
    public static void genereazaOutput2(String fisierInput, String fisierOutput) throws Exception {
        FileInputStream fis = new FileInputStream(fisierInput);
        XSSFWorkbook wbIn = new XSSFWorkbook(fis);
        XSSFSheet sheetIn = wbIn.getSheetAt(0);

        XSSFWorkbook wbOut = new XSSFWorkbook();
        XSSFSheet sheetOut = wbOut.createSheet("Sheet1");

        int numarRnad = 0;
        for (Row rowIn : sheetIn) {
            Row rowOut = sheetOut.createRow(numarRnad++);
            int colNum = 0;

            for (Cell cellIn : rowIn) {
                Cell cellOut = rowOut.createCell(colNum++);
                if (cellIn.getCellType() == CellType.STRING) {
                    cellOut.setCellValue(cellIn.getStringCellValue());
                } else if (cellIn.getCellType() == CellType.NUMERIC) {
                    cellOut.setCellValue(cellIn.getNumericCellValue());
                }
            }

            if (numarRnad == 1) {
                rowOut.createCell(colNum).setCellValue("Medie");
            } else {
                double nota1 = rowIn.getCell(3).getNumericCellValue();
                double nota2 = rowIn.getCell(4).getNumericCellValue();
                double nota3 = rowIn.getCell(5).getNumericCellValue();
                double medie = (nota1 + nota2 + nota3) / 3.0;
                rowOut.createCell(colNum).setCellValue(medie);
            }
        }

        FileOutputStream fos = new FileOutputStream(fisierOutput);
        wbOut.write(fos);
        fos.close();
        wbIn.close();
        wbOut.close();
        System.out.println("Generat: " + fisierOutput);
    }

    // 8.5.3
    public static void genereazaOutput3(String fisierInput, String fisierOutput) throws Exception {
        FileInputStream fis = new FileInputStream(fisierInput);
        XSSFWorkbook wbIn = new XSSFWorkbook(fis);
        XSSFSheet sheetIn = wbIn.getSheetAt(0);

        XSSFWorkbook wbOut = new XSSFWorkbook();
        XSSFSheet sheetOut = wbOut.createSheet("Sheet1");

        int numarRand = 0;
        for (Row rowIn : sheetIn) {
            Row rowOut = sheetOut.createRow(numarRand++);
            int colNum = 0;

            for (Cell cellIn : rowIn) {
                Cell cellOut = rowOut.createCell(colNum++);
                if (cellIn.getCellType() == CellType.STRING) {
                    cellOut.setCellValue(cellIn.getStringCellValue());
                } else if (cellIn.getCellType() == CellType.NUMERIC) {
                    cellOut.setCellValue(cellIn.getNumericCellValue());
                }
            }

            if (numarRand == 1) {
                rowOut.createCell(colNum).setCellValue("Medie");
            } else {
                rowOut.createCell(colNum).setCellFormula(
                        "AVERAGE(D" + numarRand + ":F" + numarRand + ")"
                );
            }
        }

        FileOutputStream fos = new FileOutputStream(fisierOutput);
        wbOut.write(fos);
        fos.close();
        wbIn.close();
        wbOut.close();
        System.out.println("Generat: " + fisierOutput);
    }
}