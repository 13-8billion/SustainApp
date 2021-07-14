package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.classes.FoodTotal;
import sustain.project.interfaces.FoodTotalRepo;

import java.util.List;

@Service
@Transactional
public class FoodTotalService {
    @Autowired
    private FoodTotalRepo repo;

    public List<FoodTotal> listAll() {
        return repo.findAll();
    }

    public void save(FoodTotal foodTotalObject) {
        repo.save(foodTotalObject);
    }

    public FoodTotal get(String username) {
        return repo.findById(username).get();
    }

    public void delete(String username) {
        repo.deleteById(username);
    }
}

