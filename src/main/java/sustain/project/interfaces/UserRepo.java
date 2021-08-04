package sustain.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sustain.project.models.User;
import sustain.project.service.UserService;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public interface UserRepo extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

}