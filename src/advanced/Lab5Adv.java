package advanced;

public class Lab5Adv {

    public static void main(String[] args) {

        //(10+5-3)*2=24
        NewIntCalculator intCalc = new NewIntCalculator();
        intCalc.init(10);
        int intResult = (Integer) intCalc.add(5).subtract(3).multiply(2).result();
        System.out.println("Int result"+" " + intResult); // 24

        //(10+5-3.3)*2.2=25.74
        DoubleCalculator doubleCalc = new DoubleCalculator();
        doubleCalc.init(10.0);
        double doubleResult = (Double) doubleCalc.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("Double result"+" " + doubleResult); // 25.74
    }



}