package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sustain.project.models.EmissionTotal;

@Repository
public interface EmissionTotalRepo extends JpaRepository<EmissionTotal, Integer> {
}