package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.models.AddEmission;

public interface AddEmissionRepo extends JpaRepository<AddEmission, String> {

}