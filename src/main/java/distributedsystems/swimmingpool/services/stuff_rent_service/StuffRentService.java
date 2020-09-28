package distributedsystems.swimmingpool.services.stuff_rent_service;

import distributedsystems.swimmingpool.services.stuff_rent_service.models.SwimmingStuff;
import distributedsystems.swimmingpool.services.stuff_rent_service.repository.SwimmingStuffRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StuffRentService implements ISwimmingStuffService {
    @Autowired
    private SwimmingStuffRepository repository;

    @Override
    public List<SwimmingStuff> findAll() {
        return (List<SwimmingStuff>) repository.findAll();
    }

    @Override
    public SwimmingStuff save(SwimmingStuff swimmingStuffForSave) {
        return repository.save(swimmingStuffForSave);
    }

    @Override
    public SwimmingStuff getById(String id) throws NotFoundException {
        Optional<SwimmingStuff> tempSwimmingStuff = repository.findById(id);
        if (tempSwimmingStuff.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Swimming Stuff with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}