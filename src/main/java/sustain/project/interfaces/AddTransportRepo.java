package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sustain.project.models.AddTransport;

@Repository
public interface AddTransportRepo  extends JpaRepository<AddTransport, String> {
}