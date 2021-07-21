package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.models.AddHouse;

public interface AddHouseRepo extends JpaRepository<AddHouse, String> {

}