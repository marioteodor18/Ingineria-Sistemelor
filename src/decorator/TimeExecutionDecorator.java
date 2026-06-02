package decorator;
import lab2.Student;
import lab10.IStudentiExport;
import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {
    private List<Student> studenti;
    private IStudentiExport exporter;


    public TimeExecutionDecorator(IStudentiExport exporter, List<Student> studenti) {
        super();
        this.studenti = studenti;
    }


    public TimeExecutionDecorator(IStudentiExport exporter) {

        this.exporter = exporter;
    }
    public long executionTime(List<Student> studenti) {
        long startCronometru= System.currentTimeMillis();
        exporter.doExport(studenti);
        long stopCronometru = System.currentTimeMillis();
        System.out.println("Timpul dupa export: " + (stopCronometru - startCronometru));
        long durata = stopCronometru - startCronometru;
        System.out.println("Timp executie: " + durata + " ms pentru " + exporter);
        return durata;
    }
}