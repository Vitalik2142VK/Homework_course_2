package sp.course2.homeworks_2.homework_13;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> getListEmployeesInDepartment(@PathVariable int id) {
        return departmentService.getListEmployeesInDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public int getSumWageEmployeeInDepartment(@PathVariable int id) {
        return departmentService.getSumWageEmployeeInDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/max")
    public int getMaximumWageEmployeeInDepartment(@PathVariable int id) {
        return departmentService.getMaximumWageEmployeeInDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/min")
    public int getMinimumWageEmployeeInDepartment(@PathVariable int id) {
        return departmentService.getMinimumWageEmployeeInDepartment(id);
    }

    @GetMapping(path = "/employees")
    public Map<Integer,List<Employee>> getAllEmployee() {
        return departmentService.getAllEmployee();
    }
}
