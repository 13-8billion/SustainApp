package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.models.HouseEnergyTotal;

public interface HouseEnergyTotalRepo extends JpaRepository<HouseEnergyTotal, String> {

}
