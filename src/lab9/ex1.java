package lab9;
import java.util.*;
import java.util.stream.*;



public class ex1 {
    public static void main (String[] args){
        Random random=new Random();

        //generz lista de 10 numere
        List<Integer>numere=IntStream.range(0,10).map(i->5+random.nextInt(21)).boxed().collect(Collectors.toList());
        System.out.println("Lista cu 10 numere:"+numere);
        //a)suma elemn din lista
        int suma=numere.stream().reduce(0,Integer::sum);
        System.out.println("Suma:"+suma);
        //b)maximu si minimu
        int max=numere.stream().max(Comparator.naturalOrder()).get();
        int min=numere.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Max:"+max+" Min:"+min);
        //c) elementele in intervalul 10..20
        List<Integer>inInterval=numere.stream().filter(n->n>=10&&n<=20).collect(Collectors.toList());
        System.out.println("Interval.10...20:"+inInterval);
        //d)convertite la double
        List<Double>convertite=numere.stream().map(n->n.doubleValue()).collect(Collectors.toList());
        //e) verificare daca exista 12
        boolean exista12=numere.stream().anyMatch(n->n==12);
        System.out.println("exista12:"+exista12);







    }
}
