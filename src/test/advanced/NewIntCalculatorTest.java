package advanced;
import org.junit.jupiter.api.*;

public class NewIntCalculatorTest {

    private NewIntCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new NewIntCalculator();
        calc.init(10);
    }

    @AfterEach
    public void tearDown() {
        calc = null;
    }

    // ADD
    @Test
    public void testAddPositive() {
        //arrange - calc initializat cu 10 in setUp
        //act
        calc.add(5);
        //assert
        Assertions.assertEquals(15, calc.result());
    }

    @Test
    public void testAddNegatives() {
        //arrange
        //act
        calc.add(-3);
        //assert
        Assertions.assertEquals(7, calc.result());
    }

    // SUBTRACT
    @Test
    public void testSubtractPositives() {
        //act
        calc.subtract(3);
        //assert
        Assertions.assertEquals(7, calc.result());
    }

    @Test
    public void testSubtractNegatives() {
        //act
        calc.subtract(-5);
        //assert
        Assertions.assertEquals(15, calc.result());
    }

    // MULTIPLY
    @Test
    public void testMultiplyPositives() {
        //act
        calc.multiply(3);
        //assert
        Assertions.assertEquals(30, calc.result());
    }

    @Test
    public void testMultiplyNegatives() {
        //act
        calc.multiply(-2);
        //assert
        Assertions.assertEquals(-20, calc.result());
    }

    @Test
    public void testMultiplyBy0() {
        //act
        calc.multiply(0);
        //assert
        Assertions.assertEquals(0, calc.result());
    }

    // DIVIDE
    @Test
    public void testDividePositives() {
        //act
        calc.divide(2);
        //assert
        Assertions.assertEquals(5, calc.result());
    }

    @Test
    public void testDivideNegatives() {
        //act
        calc.divide(-2);
        //assert
        Assertions.assertEquals(-5, calc.result());
    }

    // 6.8.2 - negative path
    @Test
    public void testDivideBy0() {
        //assert - impartirea la 0 in Java int arunca ArithmeticException
        Assertions.assertThrows(ArithmeticException.class, () -> {
            //act
            calc.divide(0);
        });
    }
}