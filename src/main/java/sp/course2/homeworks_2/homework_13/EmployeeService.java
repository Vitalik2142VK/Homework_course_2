package sp.course2.homeworks_2.homework_13;


import org.springframework.stereotype.Service;
import sp.course2.homeworks_2.homework_13.exeptions.*;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Иванович", 1, 2000),
            new Employee("Семен", "Гарилов", 3, 1800),
            new Employee("Петр", "Терешкович", 2, 2100),
            new Employee("Александра", "Иванова", 1, 2050),
            new Employee("Борис", "Бритва", 3, 1950),
            new Employee("Ксения", "Наумова", 2, 1900)
    ));

    public String addEmployee(String firstName, String lastName, int department, int wages) {
        try {
            int maxEmployee = 10;
            if (employees.size() >= maxEmployee) {
                throw new EmployeeStorageIsFullException();
            }

            employees.forEach(e -> {
                if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName)) {
                    throw new EmployeeAlreadyAddedException();
                }
            });

            employees.add(new Employee(firstName, lastName, department, wages));
            return "Сотрудник:<br>" + employees.get(employees.size()-1) + "<br>Добавлен.";
        } catch (EmployeeStorageIsFullException e) {
            return "Данные переполнены, сотрудника добавить не возможно.";
        } catch (EmployeeAlreadyAddedException e) {
            return "Такой сотрудник уже есть в списке.";
        }
    }

    public String removeEmployee(String firstName, String lastName) {
        try {
            Employee delEmployee = employees.stream()
                    .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                    .findAny()
                    .orElseThrow(EmployeeNotFoundException::new);

            employees.remove(delEmployee);
            return "Сотрудник " + delEmployee + " удален.";
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден";
        }
    }

    public String findEmployee(String firstName, String lastName) {
        try {
            Employee fEmployee = employees.stream()
                    .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                    .findAny()
                    .orElseThrow(EmployeeNotFoundException::new);

            return "Сотрудник " + fEmployee + " найден.";
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден.";
        }
    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public void removeAllEmployees() {
        employees.clear();
    }
}
