import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();

        // Pruebas con valores positivos y negativos
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(0, 0));
        assertEquals(-10, calculator.add(-5, -5));

        // Pruebas con límites
        assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE - 1, 1));
        assertEquals(Integer.MIN_VALUE, calculator.add(Integer.MIN_VALUE + 1, -1));

        // Pruebas con números grandes
        assertEquals(1000000000, calculator.add(999999999, 1));
        assertEquals(-1000000000, calculator.add(-999999999, -1));
    }

    @Test
    public void testSubstract(){
        Calculator calculator = new Calculator();
        assertEquals(-1, calculator.subtract(2, 3));
        assertEquals(0, calculator.subtract(5, 5));
        assertEquals(10, calculator.subtract(5, -5));

        // Pruebas con límites
        assertEquals(Integer.MIN_VALUE, calculator.subtract(Integer.MIN_VALUE + 1, 1));
        assertEquals(Integer.MAX_VALUE, calculator.subtract(Integer.MAX_VALUE - 1, -1));

        // Pruebas con números grandes
        assertEquals(1, calculator.subtract(1000000000, 999999999));
        assertEquals(-1, calculator.subtract(-1000000000, -999999999));
    }
    @Test
    public void testMultiply(){
        Calculator calculator = new Calculator();

        // Pruebas básicas
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-15, calculator.multiply(3, -5));

        // Pruebas con límites
        assertEquals(Integer.MAX_VALUE, calculator.multiply(Integer.MAX_VALUE, 1));
        assertEquals(-Integer.MAX_VALUE, calculator.multiply(Integer.MAX_VALUE, -1));

        // Pruebas con valores negativos y positivos
        assertEquals(-10, calculator.multiply(-5, 2));
        assertEquals(-33, calculator.multiply(-3, 11));
        assertEquals(50, calculator.multiply(10, 5));
    }
    @Test
    public void divide(){
        Calculator calculator = new Calculator();
        // Pruebas básicas
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(0, calculator.divide(0, 5));
        assertEquals(-3, calculator.divide(15, -5));

        // Pruebas con división entre cero
        try {
            calculator.divide(10, 0);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            // Se espera una excepción de división entre cero
        }

        // Pruebas con valores negativos y positivos
        assertEquals(-2, calculator.divide(-10, 5));
        assertEquals(-1, calculator.divide(-3, 3));
        assertEquals(2, calculator.divide(10, 5));
    }
}
