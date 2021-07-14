package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sustain.project.classes.Food;
@Repository
public interface FoodRepo extends JpaRepository<Food, String> {
}
