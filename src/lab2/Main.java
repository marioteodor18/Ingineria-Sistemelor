package lab2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++)
            x.add(random.nextInt(11));
        for (int i = 0; i < 7; i++)
            y.add(random.nextInt(11));

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x" + x);
        System.out.println("Lista y" + y);

        //a xplusy
    }
}