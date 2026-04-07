package java.ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NewIntCalculatorTest {

    private NewIntCalculator calculator;

    @BeforeEach
    public void setUp() {

        calculator = new NewIntCalculator();
        calculator.init();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAddPositive() {

        Integer result = calculator.add(5).add(3).result();


        Assertions.assertEquals(8, result);
    }

    @Test
    public void testAddNegatives() {

        calculator.init();


        Integer result = calculator.add(-4).add(-6).result();


        Assertions.assertEquals(-10, result);
    }


    @Test
    public void testSubtractPositives() {

        calculator.init();


        Integer result = calculator.add(10).subtract(4).result();


        Assertions.assertEquals(6, result);
    }

    @Test
    public void testSubtractNegatives() {

        calculator.init();


        Integer result = calculator.add(-3).subtract(-7).result();


        Assertions.assertEquals(4, result);
    }


    @Test
    public void testMultiplyPositives() {

        calculator.init();


        Integer result = calculator.add(4).multiply(5).result();


        Assertions.assertEquals(20, result);
    }

    @Test
    public void testMultiplyNegatives() {

        calculator.init();


        Integer result = calculator.add(-3).multiply(-4).result();

        Assertions.assertEquals(12, result);
    }

    @Test
    public void testMultiplyBy0() {

        calculator.init();


        Integer result = calculator.add(99).multiply(0).result();

        Assertions.assertEquals(0, result);
    }


    @Test
    public void testDividePositives() {

        calculator.init();


        Integer result = calculator.add(20).divide(4).result();

        Assertions.assertEquals(5, result);
    }

    @Test
    public void testDivideNegatives() {

        calculator.init();


        Integer result = calculator.add(-12).divide(-3).result();


        Assertions.assertEquals(4, result);
    }


    @Test
    public void testDivideBy0() {

        calculator.init();
        calculator.add(10);


        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0);
        });
    }
}
