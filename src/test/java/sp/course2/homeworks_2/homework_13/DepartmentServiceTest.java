package sp.course2.homeworks_2.homework_13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sp.course2.homeworks_2.homework_13.exeptions.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    Integer department;
    List<Employee> otherEmpList;
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        Mockito.when(employeeService.getEmployees())
                .thenReturn(
                        new ArrayList<>(List.of(
                                new Employee("Иван", "Иванович", 1, 2000),
                                new Employee("Семен", "Гарилов", 3, 1800),
                                new Employee("Петр", "Терешкович", 2, 2100),
                                new Employee("Александра", "Иванова", 1, 2050),
                                new Employee("Борис", "Бритва", 3, 1950),
                                new Employee("Ксения", "Наумова", 2, 1900)
                        ))
                );

        otherEmpList = new ArrayList<>(List.of(
                new Employee("Петр", "Терешкович", 2, 2100),
                new Employee("Ксения", "Наумова", 2, 1900)
        ));
        departmentService = new DepartmentService(employeeService);
        department = 2;
    }

    @Test
    public void notNullEmployeeService() {
        assertNotNull(employeeService);
    }

    @Test
    public void notFoundException() {
        String exceptionMess = "Сотрудников в данном отделе нет.";
        try {
            departmentService.getListEmployeesInDepartment(5);
        } catch (EmployeeNotFoundException ex) {
            assertEquals(exceptionMess, ex.getMessage());
        }
    }

    @Test
    public void getListEmployeesInDepartment() {
        String exceptionMess = "Сотрудников в данном отделе нет.";
        try {
            departmentService.getListEmployeesInDepartment(department);
        } catch (EmployeeNotFoundException ex) {
            assertEquals(exceptionMess, ex.getMessage());
        }

        List<Employee> actual = otherEmpList;

        assertEquals(departmentService.getListEmployeesInDepartment(department), actual);
    }

    @Test
    public void getSumWageEmployeeInDepartment() {
        String exceptionMess = "Сотрудников в данном отделе нет.";
        try {
            departmentService.getSumWageEmployeeInDepartment(department);
        } catch (EmployeeNotFoundException ex) {
            assertEquals(exceptionMess, ex.getMessage());
        }

        int actual = 0;
        for (final var el : otherEmpList) {
            actual += el.getWages();
        }

        assertEquals(departmentService.getSumWageEmployeeInDepartment(department), actual);
    }

    @Test
    public void getMaximumWageEmployeeInDepartment() {
        Employee employee = otherEmpList.stream()
                .filter(e -> e.getDepartment() == 2)
                .max(Comparator.comparingInt(e -> e.getWages()))
                .orElseThrow(EmployeeNotFoundException::new);

        int actual = employee.getWages();

        assertEquals(departmentService.getMaximumWageEmployeeInDepartment(department), actual);
    }

    @Test
    public void getMinimumWageEmployeeInDepartment() {
        Employee employee = otherEmpList.stream()
                .filter(e -> e.getDepartment() == 2)
                .min(Comparator.comparingInt(e -> e.getWages()))
                .orElseThrow(EmployeeNotFoundException::new);

        int actual = employee.getWages();

        assertEquals(departmentService.getMinimumWageEmployeeInDepartment(department), actual);
    }

    @Test
    public void getAllEmployee() {
        String exceptionMess = "Список сотрудников пуст";
        try {
            departmentService.getAllEmployee();
        } catch (EmployeeNotFoundException ex) {
            assertEquals(exceptionMess, ex.getMessage());
        }

        Map<Integer, List<Employee>> actual = new TreeMap<>(Map.of(
                1, new ArrayList<Employee>(List.of(
                        new Employee("Иван", "Иванович", 1, 2000),
                        new Employee("Александра", "Иванова", 1, 2050))),
                2, new ArrayList<Employee>(List.of(
                        new Employee("Петр", "Терешкович", 2, 2100),
                        new Employee("Ксения", "Наумова", 2, 1900))),
                3, new ArrayList<Employee>(List.of(
                        new Employee("Семен", "Гарилов", 3, 1800),
                        new Employee("Борис", "Бритва", 3, 1950)))
        ));

        assertEquals(departmentService.getAllEmployee(), actual);
    }
}
