package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.models.AddFlight;

public interface AddFlightRepo extends JpaRepository<AddFlight, String> {

}
