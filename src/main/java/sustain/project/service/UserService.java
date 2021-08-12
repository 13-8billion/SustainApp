package sustain.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import sustain.project.controllers.AppController;
import sustain.project.models.User;
import sustain.project.interfaces.UserRepo;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.Validator;


@Service
@Configurable
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

    public User get(int userID) {
        return repo.findById(userID).get();
    }

    public void delete(int userID) {
        repo.deleteById(userID);
    }

}