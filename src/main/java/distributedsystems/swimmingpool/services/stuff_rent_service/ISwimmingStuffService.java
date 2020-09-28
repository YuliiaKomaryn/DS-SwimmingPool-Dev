package distributedsystems.swimmingpool.services.stuff_rent_service;

import distributedsystems.swimmingpool.services.stuff_rent_service.models.SwimmingStuff;
import javassist.NotFoundException;

import java.util.List;

public interface ISwimmingStuffService {
    List<SwimmingStuff> findAll();

    SwimmingStuff save(SwimmingStuff swimmingStuffForSave);

    SwimmingStuff getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}