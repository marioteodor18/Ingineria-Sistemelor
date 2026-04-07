package java.ro.ulbs.proiectaresoftware.students;
import lab2.StudentBursier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lab2.Student;
import java.util.ArrayList;
import java.util.List;

public class AplicatieCuBursaTest {

    AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

    @Test
    void sortTest1() {

        List<StudentBursier> lista = appCuBursa.genereaza();

        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);


        for (int i = 0; i < sortata.size() - 1; i++) {
            StudentBursier curent  = sortata.get(i);
            StudentBursier urmator = sortata.get(i + 1);

            int cmpFormatie = curent.getFormatieDeStudiu().compareTo(urmator.getFormatieDeStudiu());
            if (cmpFormatie != 0) {
                Assertions.assertTrue(cmpFormatie <= 0,
                    "Formatia de studiu nu e sortata corect la pozitia " + i);
                continue;
            }

            int cmpNume = curent.getNume().compareTo(urmator.getNume());
            if (cmpNume != 0) {
                Assertions.assertTrue(cmpNume <= 0,
                    "Numele nu e sortat corect la pozitia " + i);
                continue;
            }

            int cmpPrenume = curent.getPrenume().compareTo(urmator.getPrenume());
            if (cmpPrenume != 0) {
                Assertions.assertTrue(cmpPrenume <= 0,
                    "Prenumele nu e sortat corect la pozitia " + i);
                continue;
            }

            if (Double.compare(curent.getNota(), urmator.getNota()) != 0) {
                Assertions.assertTrue(curent.getNota() <= urmator.getNota(),
                    "Nota nu e sortata corect la pozitia " + i);
                continue;
            }

            Assertions.assertTrue(curent.getCuantumBursa() <= urmator.getCuantumBursa(),
                "Cuantumul bursei nu e sortat corect la pozitia " + i);
        }
    }

    // ================================================================
    // Test 2: Lista vida ramane vida dupa sortare
    // ================================================================
    @Test
    void sortTestListaGoala() {
        // Arrange
        List<StudentBursier> listaGoala = new ArrayList<>();

        // Act
        List<StudentBursier> sortata = appCuBursa.sorteaza(listaGoala);

        // Assert
        Assertions.assertNotNull(sortata);
        Assertions.assertEquals(0, sortata.size());
    }

    // ================================================================
    // Test 3: Lista cu un singur element ramane neschimbata
    // ================================================================
    @Test
    void sortTestUnSingurElement() {

        List<StudentBursier> lista = new ArrayList<>();
        StudentBursier student = new StudentBursier(1001, "Ana", "Pop", "ISM141/1", 9.0, 500.0);
        lista.add(student);


        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);


        Assertions.assertEquals(1, sortata.size());
        Assertions.assertEquals(student, sortata.get(0));
    }

    // ================================================================
    // Test 4: Sortare dupa formatie de studiu (criteriul principal)
    // ISM141/1 < TI131/1 alfabetic => studentul ISM trebuie sa fie primul
    // ================================================================
    @Test
    void sortTestDupaFormatie() {

        List<StudentBursier> lista = new ArrayList<>();
        StudentBursier sT  = new StudentBursier(1001, "Zara", "Zara", "TI131/1",  9.0, 500.0);
        StudentBursier sI  = new StudentBursier(1002, "Ana",  "Ana",  "ISM141/1", 8.0, 400.0);
        lista.add(sT);
        lista.add(sI);


        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);


        Assertions.assertEquals(sI, sortata.get(0), "ISM141/1 trebuie sa fie primul");
        Assertions.assertEquals(sT, sortata.get(1), "TI131/1 trebuie sa fie al doilea");
    }

    // ================================================================
    // Test 5: Sortare dupa cuantum bursa (ultimul criteriu)
    // Acelasi student, aceeasi formatie/nume/prenume/nota, burse diferite
    // ================================================================
    @Test
    void sortTestDupaBursa() {

        List<StudentBursier> lista = new ArrayList<>();
        StudentBursier sBursa800 = new StudentBursier(1001, "Ana", "Pop", "ISM141/1", 9.0, 800.0);
        StudentBursier sBursa500 = new StudentBursier(1001, "Ana", "Pop", "ISM141/1", 9.0, 500.0);
        lista.add(sBursa800);
        lista.add(sBursa500);


        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);


        Assertions.assertEquals(500.0, sortata.get(0).getCuantumBursa(), 0.001);
        Assertions.assertEquals(800.0, sortata.get(1).getCuantumBursa(), 0.001);
    }


    @Test
    void sortTestListaOriginalaNemodificata() {

        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> copieOriginala = new ArrayList<>(lista);


        appCuBursa.sorteaza(lista);


        Assertions.assertEquals(copieOriginala, lista,
            "sorteaza() nu trebuie sa modifice lista originala");
    }
}
