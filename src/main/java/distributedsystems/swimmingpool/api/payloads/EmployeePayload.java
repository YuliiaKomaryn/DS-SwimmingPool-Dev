package distributedsystems.swimmingpool.api.payloads;

public class EmployeePayload {
    private String name;
    private String surname;
    private double salary;
    private String post;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPost() {
        return post;
    }

    public double getSalary() {
        return salary;
    }
}
