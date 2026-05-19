package decorator;
import lab10.IStudentiExport;
import lab2.Student;
import java.util.List;

public abstract class TimeExecution implements InterfaceTimeExecution {

    public IStudentiExport exporter;

    public TimeExecution(IStudentiExport exporter) {
        this.exporter = exporter;
    }

    public long executionTime(List<Student> studenti) {
        return 0;
    }
}