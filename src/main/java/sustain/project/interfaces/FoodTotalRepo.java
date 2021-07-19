package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sustain.project.models.FoodTotal;
@Repository
public interface FoodTotalRepo extends JpaRepository<FoodTotal, String> {
}