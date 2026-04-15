
import lab2.StudentBursier;
import lab6.AplicatieCuBursa;
import org.junit.jupiter.api.*;
import java.util.List;

    public class AplicatieCuBursaTest {

        AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

        @Test
        void sortTest1() {

            List<StudentBursier> lista = appCuBursa.genereaza();


            List<StudentBursier> sortata = appCuBursa.sorteaza(lista);

            //assert verificam 2 cate 2
            for (int i = 0; i < sortata.size() - 1; i++) {
                StudentBursier s1 = sortata.get(i);
                StudentBursier s2 = sortata.get(i + 1);

                int cmpFormatie = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
                int cmpNume     = s1.getNume().compareTo(s2.getNume());
                int cmpPrenume  = s1.getPrenume().compareTo(s2.getPrenume());
                int cmpNota     = Double.compare(s1.getNota(), s2.getNota());

                // formatia lui s1 trebuie sa fie mai mica sau egala decat formatia lui s2
                Assertions.assertTrue(cmpFormatie <= 0,
                        "Formatia nu e sortata corect intre " + s1 + " si " + s2);

                if (cmpFormatie == 0) {
                    Assertions.assertTrue(cmpNume <= 0,
                            "Numele nu e sortat corect intre " + s1 + " si " + s2);

                    if (cmpNume == 0) {
                        Assertions.assertTrue(cmpPrenume <= 0,
                                "Prenumele nu e sortat corect intre " + s1 + " si " + s2);

                        if (cmpPrenume == 0) {
                            Assertions.assertTrue(cmpNota <= 0,
                                    "Nota nu e sortata corect intre " + s1 + " si " + s2);

                            if (cmpNota == 0) {
                                Assertions.assertTrue(
                                        Double.compare(s1.getCuantumBursa(), s2.getCuantumBursa()) <= 0,
                                        "Bursa nu e sortata corect intre " + s1 + " si " + s2);
                            }
                        }
                    }
                }
            }
        }
    }

