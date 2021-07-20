package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sustain.project.models.OverAllTotal;

@Repository
public interface OverAllTotalRepo  extends JpaRepository<OverAllTotal, String> {
}