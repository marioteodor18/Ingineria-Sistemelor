package lab10;
import lab2.Student;
import java.util.List;

public  class StudentiInConsola implements IStudentiExport {


    public void doExport(List<Student> studenti) {
        System.out.println("=== Export studenti in consola ===");
        for (Student s : studenti) {
            System.out.printf( s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), s.getNota());
        }
        System.out.println("Total studenti: " + studenti.size());
    }
}