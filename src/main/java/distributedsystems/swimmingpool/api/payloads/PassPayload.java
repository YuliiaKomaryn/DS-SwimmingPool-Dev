package distributedsystems.swimmingpool.api.payloads;

import java.time.LocalDate;

public class PassPayload {
    private String type;
    private int price;
    LocalDate expireDate;

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }
}
