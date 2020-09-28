package distributedsystems.swimmingpool.api.payloads;

import java.time.LocalDate;

public class PassPayload {
    private String type;
    private int price;

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

}
