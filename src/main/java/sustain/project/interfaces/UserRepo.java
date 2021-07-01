package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.classes.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}