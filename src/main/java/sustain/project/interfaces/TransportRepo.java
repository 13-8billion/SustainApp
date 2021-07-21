package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sustain.project.models.Food;
import sustain.project.models.Transport;

@Repository
public interface TransportRepo extends JpaRepository<Transport, String> {
}
