package repository;

import com.ks.otpservice.model.ServiceClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCleintRepository extends CrudRepository<ServiceClient, Long> {
}
