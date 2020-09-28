package distributedsystems.swimmingpool.services.purchase_services;

import distributedsystems.swimmingpool.services.purchase_services.models.Pass;
import javassist.NotFoundException;

import java.util.List;

public interface IPurchaseService {
    List<Pass> findAll();

    Pass save(Pass passForSave);

    Pass getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}
