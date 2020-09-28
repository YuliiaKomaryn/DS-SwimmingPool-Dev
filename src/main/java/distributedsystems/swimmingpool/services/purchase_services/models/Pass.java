package distributedsystems.swimmingpool.services.purchase_services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "pass")

public class Pass {
    @Id
    private String pass_id;
    String type;
    int price;

    public Pass(String type,
                  int price) {
        this.type = type;
        this.price = price;
        this.pass_id = UUID.randomUUID().toString();
    }

    public Pass() {

    }

    public String getPass_id() {
        return pass_id;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

}

