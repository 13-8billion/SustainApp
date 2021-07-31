package sustain.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sustain.project.models.User;
import sustain.project.interfaces.UserRepo;

import java.util.List;
import javax.validation.Valid;
import javax.validation.Validator;

@Service
public class UserService {

    @Autowired
    private Validator validator;

    @Autowired
    private UserRepo repo;

    public List<User> listAll() {
        return repo.findAll();
    }

    public void save(@Valid User user) {
        repo.save(user);
    }

    public User get(String username) {
        return repo.findById(username).get();
    }

    public void delete(String username) {
        repo.deleteById(username);
    }
}