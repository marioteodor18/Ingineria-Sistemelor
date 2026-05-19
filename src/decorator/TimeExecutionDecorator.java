package decorator;
import lab2.Student;
import lab10.IStudentiExport;
import lab10.IStudentiExport;
import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {
    private List<Student> studenti;
    public TimeExecutionDecorator(IStudentiExport exporter, List<Student> studenti) {
        super(exporter);
        this.studenti = studenti;
    }
    public long executionTime(List<Student> studenti) {
        long startTime = System.currentTimeMillis();
        exporter.doExport(studenti);
        long endTime = System.currentTimeMillis();    // timpul DUPA export
        System.out.println("Timpul dupa export: " + (endTime - startTime));
        long duration = endTime - startTime;
        System.out.println("Timp executie: " + duration + " ms pentru " + exporter);
        return duration;
    }
}