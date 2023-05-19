package sp.course2.homeworks_2.homework_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {
    private Float number1, number2;
    private CalculatorService calculator;

    @BeforeEach
    public void setUp() {
        number1 = 5f;
        number2 = 0f;

        calculator = new CalculatorService();
    }

    @Test
    public void sum() {
        String result = number1 + " + " + number2 + " = " + (number1+number2);
        assertEquals(result, calculator.plus(number1, number2));
    }

    @Test
    public void minus() {
        String result = number1 + " - " + number2 + " = " + (number1-number2);
        assertEquals(result, calculator.minus(number1, number2));
    }

    @Test
    public void multiply() {
        String result = number1 + " * " + number2 + " = " + (number1*number2);
        assertEquals(result, calculator.multiply(number1, number2));
    }

    @Test
    public void divide() {
        if (number2 == 0)
            fail("Делитель равен нулю! На ноль делить нельзя!");
        String result = number1 + " / " + number2 + " = " + (number1/number2);
        assertEquals(result, calculator.divide(number1, number2));
    }

    @Test
    public void proveDelProve() {
        String result = "Делить на 0 нельзя!!!";
        try {
            if (number2 == 0) throw new NumLessThanZero(result);
        } catch (NumLessThanZero ex) {
            assertEquals(result, ex.getMessage());
        }
    }
}
