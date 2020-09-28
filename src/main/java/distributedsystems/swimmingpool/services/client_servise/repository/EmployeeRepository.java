package distributedsystems.swimmingpool.services.client_servise.repository;

import distributedsystems.swimmingpool.services.client_servise.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}

