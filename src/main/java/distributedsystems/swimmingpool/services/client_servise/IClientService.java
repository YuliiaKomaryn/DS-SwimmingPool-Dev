package distributedsystems.swimmingpool.services.client_servise;

import distributedsystems.swimmingpool.services.client_servise.models.Client;
import javassist.NotFoundException;

import java.util.List;

public interface IClientService {
    List<Client> findAll();

    Client save(Client clientForSave);

    Client getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}