package sp.course2.homeworks_2.homework_13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sp.course2.homeworks_2.homework_13.exeptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {
    private List<Employee> employees;
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>(List.of(
                new Employee("Федор", "Ситников", 1, 1800),
                new Employee("Иван", "Иванов", 2, 1950),
                new Employee("Алекс", "Бодски", 3, 2000),
                new Employee("Мол", "Дориан", 4, 1900)
        ));

        employeeService = new EmployeeService();
    }

    @Test
    public void addEmployee() {
        String firstName = "Федор", lastName = "Ситников";

        employeeService.removeAllEmployees();

        EmployeeService actual = new EmployeeService();
        actual.removeAllEmployees();

        assertEquals(actual.addEmployee(firstName, lastName, 1, 1800), employeeService.addEmployee(firstName, lastName, 1, 1800));
        assertEquals(actual.getEmployees(), employeeService.getEmployees());
        assertEquals(actual.findEmployee(firstName, lastName), employeeService.findEmployee(firstName, lastName));
    }

    @Test
    public void fullException() {
        String result = "Данные переполнены, сотрудника добавить не возможно.";
        for (final var emp : employees) {
            employeeService.addEmployee(emp.getFirstName(), emp.getLastName(), emp.getDepartment(), emp.getWages());
        }

        assertEquals(result, employeeService.addEmployee("Степан", "Романов", 2, 1900));
    }

    @Test
    public void addedException() {
        String result = "Такой сотрудник уже есть в списке.";
        employeeService.addEmployee("Степан", "Романов", 2, 1900);

        assertEquals(result, employeeService.addEmployee("Степан", "Романов", 2, 1900));
    }

    @Test
    public void findEmployee() {
        String firstName = "Федор", lastName = "Ситников";

        employeeService.addEmployee(firstName, lastName, 1, 1800);

        EmployeeService actual = new EmployeeService();
        actual.addEmployee(firstName, lastName, 1, 1800);

        assertEquals(actual.findEmployee(firstName, lastName), employeeService.findEmployee(firstName, lastName));
    }

    @Test
    public void notFindException() {
        String result = "Сотрудник не найден.";

        assertEquals(result, employeeService.findEmployee("Степан", "Романов"));
    }

    @Test
    public void removeEmployee() {
        Employee delEmployee = new Employee("Степан", "Романов", 2, 1900);
        String result = "Сотрудник " + delEmployee + " удален.";

        employeeService.addEmployee("Степан", "Романов", 2, 1900);
        assertEquals(result, employeeService.removeEmployee("Степан", "Романов"));
    }
}
