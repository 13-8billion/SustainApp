package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.models.HouseEnergy;

public interface HouseEnergyRepo extends JpaRepository<HouseEnergy, String> {

}
