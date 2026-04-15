package advanced;
import org.junit.jupiter.api.*;

public class DoubleCalculatorTest {

    private DoubleCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new DoubleCalculator();
        calc.init(10.0);
    }

    @AfterEach
    public void tearDown() {
        calc = null;
    }


    @Test
    public void testAddPositive() {
        calc.add(5.0);
        Assertions.assertEquals(15.0, (Double) calc.result(), 0.001);
    }

    @Test
    public void testAddNegatives() {
        calc.add(-3.0);
        Assertions.assertEquals(7.0, (Double) calc.result(), 0.001);
    }


    @Test
    public void testSubtractPositives() {
        calc.subtract(3.3);
        Assertions.assertEquals(6.7, (Double) calc.result(), 0.001);
    }

    @Test
    public void testSubtractNegatives() {
        calc.subtract(-5.0);
        Assertions.assertEquals(15.0, (Double) calc.result(), 0.001);
    }


    @Test
    public void testMultiplyPositives() {
        calc.multiply(2.2);
        Assertions.assertEquals(22.0, (Double) calc.result(), 0.001);
    }

    @Test
    public void testMultiplyNegatives() {
        calc.multiply(-2.0);
        Assertions.assertEquals(-20.0, (Double) calc.result(), 0.001);
    }

    @Test
    public void testMultiplyBy0() {
        calc.multiply(0.0);
        Assertions.assertEquals(0.0, (Double) calc.result(), 0.001);
    }


    @Test
    public void testDividePositives() {
        calc.divide(2.0);
        Assertions.assertEquals(5.0, (Double) calc.result(), 0.001);
    }

    @Test
    public void testDivideNegatives() {
        calc.divide(-2.0);
        Assertions.assertEquals(-5.0, (Double) calc.result(), 0.001);
    }

    // 6.8.2

    @Test
    public void testDivideBy0() {
        calc.divide(0.0);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, (Double) calc.result());
    }
}