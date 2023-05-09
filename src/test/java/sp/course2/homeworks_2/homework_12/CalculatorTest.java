package sp.course2.homeworks_2.homework_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {
    private Float number1, number2;
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        number1 = 5f;
        number2 = 10f;

        calculator = new Calculator();
        calculator.getNumbers(number1, number2);
    }

    @Test
    public void sum() {
        float result = number1 + number2;
        assertEquals(result, calculator.plus());
    }

    @Test
    public void minus() {
        float result = number1 - number2;
        assertEquals(result, calculator.minus());
    }

    @Test
    public void multiply() {
        float result = number1 * number2;
        assertEquals(result, calculator.multiply());
    }

    @Test
    public void divide() {
        if (number2 == 0)
            fail("Делитель равен нулю! На ноль делить нельзя!");
        float result = number1 / number2;
        assertEquals(result, calculator.divide());
    }
}
