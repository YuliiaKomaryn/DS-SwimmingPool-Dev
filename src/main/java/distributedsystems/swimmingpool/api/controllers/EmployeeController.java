package distributedsystems.swimmingpool.api.controllers;

import distributedsystems.swimmingpool.api.payloads.EmployeePayload;
import distributedsystems.swimmingpool.services.client_servise.IEmployeeService;
import distributedsystems.swimmingpool.SwimmingpoolApplication;
import distributedsystems.swimmingpool.services.client_servise.models.Employee;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public final class EmployeeController {
    static final Logger log = LoggerFactory.getLogger(SwimmingpoolApplication.class);

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> index() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeePayload payload) {
        Employee newEmployee = new Employee(payload.getName(),
                payload.getSurname(),
                payload.getSalary(),
                payload.getPost());
        return ResponseEntity.ok(employeeService.save(newEmployee));
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<Employee> show(@PathVariable String employeeId) throws NotFoundException {
        return ResponseEntity.ok(employeeService.getById(employeeId));
    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable String employeeId) throws NotFoundException {
        employeeService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }
}