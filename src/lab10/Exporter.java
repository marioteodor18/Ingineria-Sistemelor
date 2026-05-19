package lab10;

import lab2.Student;

import java.util.List;

public class Exporter {


    public void startExport(IStudentiExport studentiExport, List<Student> studenti) {
       studentiExport.doExport(studenti);
    }
}
