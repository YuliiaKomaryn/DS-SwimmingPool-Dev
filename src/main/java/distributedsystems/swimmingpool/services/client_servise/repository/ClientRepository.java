package distributedsystems.swimmingpool.services.client_servise.repository;

import distributedsystems.swimmingpool.services.client_servise.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
}
