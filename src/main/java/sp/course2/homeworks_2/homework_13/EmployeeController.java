package sp.course2.homeworks_2.homework_13;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public String firstMessage() {
        return "Введите Имя и Фамилию сотрудника.";
    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam ("firstName")String firstName, @RequestParam ("lastName") String lastName,
                              @RequestParam ("department")int department, @RequestParam ("wages")int wages) {
        return employeeService.addEmployee(firstName, lastName, department, wages);
    }

    @GetMapping(path = "remove")
    public String removeEmployee(@RequestParam ("firstName")String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "find")
    public String findEmployee(@RequestParam ("firstName")String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
}
