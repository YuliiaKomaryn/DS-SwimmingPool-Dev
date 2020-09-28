package distributedsystems.swimmingpool.services.purchase_services;

import distributedsystems.swimmingpool.services.purchase_services.models.Pass;
import distributedsystems.swimmingpool.services.purchase_services.repository.PassRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService implements IPurchaseService {
    @Autowired
    private PassRepository repository;

    @Override
    public List<Pass> findAll() {
        return (List<Pass>) repository.findAll();
    }

    @Override
    public Pass save(Pass passForSave) {
        return repository.save(passForSave);
    }

    @Override
    public Pass getById(String id) throws NotFoundException {
        Optional<Pass> tempPass = repository.findById(id);
        if (tempPass.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Pass with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}