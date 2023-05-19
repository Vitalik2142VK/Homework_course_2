package sp.course2.homeworks_2.homework_13;

import sp.course2.homeworks_2.homework_13.exeptions.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class DepartmentService {

    public List<Employee> getListEmployeesInDepartment(int department) {
        List<Employee> departmentEmployees = employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
        if (departmentEmployees.size() == 0) throw new EmployeeNotFoundException("Сотрудников в данном отделе нет.");
        else return departmentEmployees;
    }

    public int getSumWageEmployeeInDepartment(int department) {
        List<Employee> sumWageEmployees = employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
        if (sumWageEmployees.size() == 0) throw new EmployeeNotFoundException("Сотрудников в данном отделе нет.");
        else {
            int result = 0;
            for (final var e : sumWageEmployees) {
                result += e.getWages();
            }
            return result;
        }
    }

    public int getMaximumWageEmployeeInDepartment(int department) {
        Employee employee = employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getWages()))
                .orElseThrow(EmployeeNotFoundException::new);
        return employee.getWages();
    }

    public int getMinimumWageEmployeeInDepartment(int department) {
        Employee employee = employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getWages()))
                .orElseThrow(EmployeeNotFoundException::new);
        return employee.getWages();
    }

    public Map<Integer,List<Employee>> getAllEmployee() {
        if (employees.size() == 0) throw new EmployeeNotFoundException("Список сотрудников пуст");

        Map<Integer, List<Employee>> allEmployees = new HashMap<>();
        Set<Integer> departments = new TreeSet<>();

        for (final var e : employees) {
            departments.add(e.getDepartment());
        }

        for (final var value : departments) {
            allEmployees.put(
                    value,
                    employees.stream()
                            .filter(emp -> emp.getDepartment() == value)
                            .collect(Collectors.toList()));
        }

        return allEmployees;
    }
}
