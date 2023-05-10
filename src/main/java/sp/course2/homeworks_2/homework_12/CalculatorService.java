package sp.course2.homeworks_2.homework_12;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String plus(float number1, float number2) {
        return number1 + " + " + number2 + " = " + (number1+number2);
    }

    public String minus(float number1, float number2) {
        return number1 + " - " + number2 + " = " + (number1-number2);
    }

    public String multiply(float number1, float number2) {
        return number1 + " * " + number2 + " = " + (number1*number2);
    }

    public String divide(float number1, float number2) {
        try {
            if (number2 == 0) throw new NumLessThanZero("Делить на 0 нельзя!!!");
            return number1 + " / " + number2 + " = " + (number1/number2);
        } catch (NumLessThanZero ex) {
            return ex.getMessage();
        }

    }
}
