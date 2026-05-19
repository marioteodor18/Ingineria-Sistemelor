package lab10;

import lab2.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

//c
public class StudentiInFisierXlsx implements IStudentiExport {

    private final String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");

            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


            Row header = sheet.createRow(0);
            String[] columns = {"ID", "Prenume", "Nume", "Grupa", "Nota"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }


            int rowNum = 1;
            for (Student s : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(s.numarMatricol);
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());
            }


            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }


            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                workbook.write(fos);
            }

            System.out.println("Export excel reusit: " + fileName
                    + " (" + studenti.size() + " studenti)");

        } catch (IOException e) {
            System.err.println("Eroare la scrierea fisierului Excel: " + e.getMessage());
        }
    }
}
