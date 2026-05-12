package lab9;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;


public class ex2 {
    public static void main(String[] args){
        String text="Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte= Arrays.asList(text.split(" "));
        //a)lungime >=5
        List<String>maiLungi=cuvinte.stream().filter(c->c.length()>2).collect(Collectors.toList());
        System.out.println("Cuvinte >= 5 litere: " + maiLungi);
        System.out.println("Count: " + maiLungi.size());
        //b)Sortare lista filtrata
        List<String>listaFiltrata=cuvinte.stream().sorted().collect(Collectors.toList());
        System.out.println("Lista sortata: " + listaFiltrata);
        //c)primul care incepe cu p
        Optional<String> primulcuP=cuvinte.stream().filter(c->c.startsWith("P")).findFirst();
        System.out.println("Primul cuvant care incepe cu p :"+primulcuP);
        







































































































    }





}
