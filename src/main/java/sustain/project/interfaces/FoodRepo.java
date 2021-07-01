package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.classes.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {
}
