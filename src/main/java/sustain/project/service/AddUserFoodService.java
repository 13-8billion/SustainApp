package sustain.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.classes.AddUserFood;
import sustain.project.interfaces.AddUserFoodRepo;

import java.util.List;

@Service
@Transactional
public class AddUserFoodService {
    @Autowired
    private AddUserFoodRepo repo;

    public List<AddUserFood> listAll() {
        return repo.findAll();
    }

    public void save(AddUserFood foodItems) {
        repo.save(foodItems);
    }

    public AddUserFood get(String username) {
        return repo.findById(username).get();
    }

    public void delete(String username) {
        repo.deleteById(username);
    }

    public void deleteAll(Iterable<AddUserFood> foodObject){
        repo.deleteAllInBatch(foodObject);
    }


}

