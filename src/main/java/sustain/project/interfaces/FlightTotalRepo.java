package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.models.FlightTotal;

public interface FlightTotalRepo extends JpaRepository<FlightTotal, Integer> {

}