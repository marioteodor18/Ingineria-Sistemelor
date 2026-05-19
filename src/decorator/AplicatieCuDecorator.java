package decorator;

import lab10.IStudentiExport;
import lab10.StudentiInConsola;
import lab10.StudentiInFisierText;
import lab10.StudentiInFisierXlsx;
import lab2.Student;
import java.util.Arrays;
import java.util.List;

public class AplicatieCuDecorator {
    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student("1025", "Andrei", "Popa", "ISM141/2", 8.70),
                new Student("1024", "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student("1026", "Anamaria", "Prodan", "TI131/1", 8.90)
        );

        List<IStudentiExport> strategies = Arrays.asList(
                new StudentiInConsola() {
                    public void exportStudenti(List<Student> studenti) {
                    }
                }, new StudentiInFisierText("studentiStrategyText.txt") {
                    public void exportStudenti(List<Student> studenti) {
                    }
                }, new StudentiInFisierXlsx("studentiStrategyExcel.xlsx"));

        for (IStudentiExport strategy : strategies) {
            TimeExecutionDecorator decorator = new TimeExecutionDecorator(strategy, studenti);
            long time = decorator.executionTime(studenti);
            System.out.println("Execution time: " + time + " for " + strategy);
        }
    }
}