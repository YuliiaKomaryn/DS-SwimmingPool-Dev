package distributedsystems.swimmingpool.services.stuff_rent_service.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "swimming_stuff")

public final class SwimmingStuff {
    @Id
    private String swimmingstuff_id;
    private String type;
    private int price;

    public SwimmingStuff(String type,
                         int price){
        this.type = type;
        this.price = price;
        this.swimmingstuff_id = UUID.randomUUID().toString();
    }

    public SwimmingStuff() {

    }

    public String getSwimmingstuff_id() {
        return swimmingstuff_id;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}