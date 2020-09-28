package distributedsystems.swimmingpool.services.purchase_services.repository;

import distributedsystems.swimmingpool.services.purchase_services.models.Pass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassRepository extends CrudRepository<Pass, String> {
}
