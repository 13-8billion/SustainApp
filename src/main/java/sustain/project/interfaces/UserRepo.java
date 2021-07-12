package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sustain.project.classes.User;

@org.springframework.stereotype.Repository
public interface UserRepo extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

}