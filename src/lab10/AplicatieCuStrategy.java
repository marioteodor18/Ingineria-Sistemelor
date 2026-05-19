
package lab10;
import lab2.Student;
import java.util.Arrays;
import java.util.List;


public class AplicatieCuStrategy {

    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
            new Student("1025", "Andrei",    "Popa",      "ISM141/2",  8.70),
            new Student("1024", "Ioan",      "Mihalcea",  "ISM141/1",  10.0),
            new Student("1026", "Anamaria",  "Prodan",    "TI131/1",   8.90),
            new Student("1029", "Bianca",    "Popescu",   "TI131/1",   10.0),
            new Student("1029", "Maria",     "Pana",      "TI131/2",   4.10),
            new Student("1029", "Gabriela",  "Mohanu",    "TI131/2",   7.33),
            new Student("1029", "Marius",    "Nasta",     "TI131/2",   3.20),
            new Student("1029", "Marius",    "Nasta",     "TI131/1",   5.12),
            new Student("1029", "Andrei",    "Dobrescu",  "TI131/2",   2.22)
        );

        Exporter exporter = new Exporter();


        // a) Afisare in consola

        System.out.println("\n--- Strategia a) ConsoleExport ---");
        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);


        // b) Export in fisier text

        System.out.println("\n--- Strategia b) TxtExport ---");
        String txtFile = "studentiStrategyText.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(txtFile);
        exporter.startExport(strategyFisierText, studenti);


        // c) Export in fisier excel

        System.out.println("\n--- Strategia c) XlsxExport ---");
        String xlsxFile = "studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(xlsxFile);
        exporter.startExport( strategyFisierExcel, studenti);


        // d) Import din fisier text

        System.out.println("\n--- Strategia d) TxtImport ---");
        StudentiDinFisierText strategyReadTxt = new StudentiDinFisierText(txtFile);
        List<Student> studentiDinTxt = strategyReadTxt.doImport();
        System.out.println("Studenti cititi din text:");
        studentiDinTxt.forEach(System.out::println);

        // e) Import din fisier excel

        System.out.println("\n--- Strategia e) excelImport ---");
        StudentiDinFisierXlsx strategyReadXlsx = new StudentiDinFisierXlsx(xlsxFile);
        List<Student> studentiDinXlsx = strategyReadXlsx.doImport();
        System.out.println("Studenti cititi din excel:");
        studentiDinXlsx.forEach(System.out::println);
    }
}
