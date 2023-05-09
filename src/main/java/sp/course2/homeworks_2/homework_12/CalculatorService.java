package sp.course2.homeworks_2.homework_12;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final Calculator calculator;

    public CalculatorService() {
        calculator = new Calculator();
    }

    public String plus(float number1, float number2) {
        calculator.getNumbers(number1, number2);
        return number1 + " + " + number2 + " = " + calculator.plus();
    }

    public String minus(float number1, float number2) {
        calculator.getNumbers(number1, number2);
        return number1 + " - " + number2 + " = " + calculator.minus();
    }

    public String multiply(float number1, float number2) {
        calculator.getNumbers(number1, number2);
        return number1 + " * " + number2 + " = " + calculator.multiply();
    }

    public String divide(float number1, float number2) {
        calculator.getNumbers(number1, number2);
        try {
            return number1 + " / " + number2 + " = " + calculator.divide();
        } catch (NumLessThanZero ex) {
            return ex.getMessage();
        }

    }
}
