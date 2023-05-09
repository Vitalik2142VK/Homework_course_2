package sp.course2.homeworks_2.homework_12;

public class Calculator {

    private float number1, number2;

    public void getNumbers(float number1, float number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public float plus() {
        return number1+number2;
    }

    public float minus() {
        return number1-number2;
    }

    public float multiply() {
        return number1*number2;
    }

    public float divide() {
        if (number2 == 0) throw new NumLessThanZero("Делить на 0 нельзя!!!");
        return number1 / number2;
    }
}
