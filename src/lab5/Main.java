package lab5;

public class Main{
    public static void main(String[] args) {
        IntCaclulator caclulator=new IntCaclulator(10);
        int result=caclulator.add(5).subtract(3).multiply(2).result();
        System.out.println("a"+ " " +result);//a 24

        AdvancedCalculator advanced=new AdvancedCalculator(100);
        int result2=advanced.divide(4).power(2).root(2).result();
        System.out.println("b"+" " +result2);//b25

    }


}
