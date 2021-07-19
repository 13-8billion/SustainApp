package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.models.AddUserFood;

public interface AddUserFoodRepo extends JpaRepository<AddUserFood, String> {

}
