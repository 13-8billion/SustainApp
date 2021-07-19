package sustain.project;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;
import sustain.project.models.User;
import sustain.project.interfaces.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepo repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("carlsagan@gmail.com");
        user.setPassword("sagan2021");
        user.setUsername("carlsagan13.8");
        user.setLocation("Earth");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getUserID());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}
