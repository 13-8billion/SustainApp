package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sustain.project.models.TransportTotal;

@Repository
public interface TransportTotalRepo extends JpaRepository<TransportTotal, String> {
}