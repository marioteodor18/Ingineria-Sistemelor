package lab7;
import lab2.Student;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 7.6.3
        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student("101", "Ion", "Popescu", "TI 211"));
        studenti.add(new Student("102", "Maria", "Ionescu", "TI 211"));
        studenti.add(new Student("103", "Ana", "Georgescu", "TI 211"));
        studenti.add(new Student("104", "Radu", "Dumitrescu", "TI 211"));
        studenti.add(new Student("105", "Elena", "Popa", "TI 211"));

        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");
        System.out.println("\n7.6.3 Studenti dupa impartire:");
        studenti.forEach(System.out::println);


        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea()+" details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());   // sau tri.getInstanceCount() sau sq.getInstanceCount()

        //7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: "+PasswordMaker.getCallingCounts());


    }



    static Student schimbaFormatia(Student st, String nouaFormatie) {
        return new Student(st.getNumarMatricol(), st.getPrenume(),
                st.getNume(), nouaFormatie);
    }

    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
        Set<Student> rezultat = new LinkedHashSet<>();
        List<Student> lista = new ArrayList<>(studenti);
        int jumatate = (lista.size() + 1) / 2;

        for (int i = 0; i < lista.size(); i++) {
            String formatie = (i < jumatate) ? formatia1 : formatia2;
            rezultat.add(schimbaFormatia(lista.get(i), formatie));
        }
        return rezultat;
    }



}
