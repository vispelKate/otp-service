package repository;

import com.ks.otpservice.model.OtpCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpCodeRepository extends CrudRepository<OtpCode,Long> {
}
