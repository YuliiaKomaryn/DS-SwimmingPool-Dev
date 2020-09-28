package distributedsystems.swimmingpool.services.client_servise;

import distributedsystems.swimmingpool.services.client_servise.models.Employee;
import javassist.NotFoundException;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee save(Employee employeeForSave);

    Employee getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}