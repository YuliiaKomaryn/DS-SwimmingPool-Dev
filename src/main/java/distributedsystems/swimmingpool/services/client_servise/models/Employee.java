package distributedsystems.swimmingpool.services.client_servise.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "employees")


public final class Employee {
    @Id
    private String employee_id;
    private String name;
    private String surname;
    private double salary;
    private String post;

    public Employee(String name,
                    String surname,
                    double salary,
                    String post) {
        this.salary = salary;
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.employee_id = UUID.randomUUID().toString();

    }


    public Employee() {

    }

    public String getEmployee_id() {
        return employee_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public String getPost() {
        return post;
    }
}