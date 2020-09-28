package distributedsystems.swimmingpool.services.stuff_rent_service.repository;

import distributedsystems.swimmingpool.services.stuff_rent_service.models.SwimmingStuff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwimmingStuffRepository extends CrudRepository<SwimmingStuff, String> {
}
