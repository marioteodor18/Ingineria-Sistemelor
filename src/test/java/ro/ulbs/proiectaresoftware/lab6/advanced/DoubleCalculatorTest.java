package java.ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DoubleCalculatorTest {

    private DoubleCalculator calculator;

    // Toleranta acceptata la compararea valorilor double
    private static final double DELTA = 0.0001;

    @BeforeEach
    public void setUp() {
        // Arrange comun: instantiem si initializam calculatorul inainte de fiecare test
        calculator = new DoubleCalculator();
        calculator.init();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    // ============================================================
    //  ADD
    // ============================================================

    @Test
    public void testAddPositive() {

        Double result = calculator.add(3.5).add(1.5).result();


        Assertions.assertEquals(5.0, result, DELTA);
    }

    @Test
    public void testAddNegatives() {

        calculator.init();


        Double result = calculator.add(-2.5).add(-1.5).result();


        Assertions.assertEquals(-4.0, result, DELTA);
    }

    @Test

        calculator.init();

        Double result = calculator.add(10.0).subtract(3.5).result();

        Assertions.assertEquals(6.5, result, DELTA);
    }

    @Test
    public void testSubtractNegatives() {

        calculator.init();


        Double result = calculator.add(-5.0).subtract(-2.0).result();

        Assertions.assertEquals(-3.0, result, DELTA);
    }


    @Test
    public void testMultiplyPositives() {

        calculator.init();


        Double result = calculator.add(2.5).multiply(4.0).result();


        Assertions.assertEquals(10.0, result, DELTA);
    }

    @Test
    public void testMultiplyNegatives() {

        calculator.init();


        Double result = calculator.add(-3.0).multiply(-2.0).result();

        Assertions.assertEquals(6.0, result, DELTA);
    }

    @Test
    public void testMultiplyBy0() {

        calculator.init();


        Double result = calculator.add(99.9).multiply(0.0).result();

        Assertions.assertEquals(0.0, result, DELTA);
    }


    @Test
    public void testDividePositives() {

        calculator.init();


        Double result = calculator.add(9.0).divide(3.0).result();

        Assertions.assertEquals(3.0, result, DELTA);
    }

    @Test
    public void testDivideNegatives() {

        calculator.init();


        Double result = calculator.add(-8.0).divide(-4.0).result();


        Assertions.assertEquals(2.0, result, DELTA);
    }
//6.8.2
    @Test
    public void testDivideBy0() {

        calculator.init();
        calculator.add(10.0);


        Double result = calculator.divide(0.0).result();

        Assertions.assertTrue(Double.isInfinite(result),
                "Impartirea unui double cu 0.0 ar trebui sa returneze Infinity, nu sa arunce exceptie");
    }
}
