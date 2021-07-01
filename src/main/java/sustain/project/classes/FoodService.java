package sustain.project.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sustain.project.interfaces.FoodRepo;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepo repo;

    public List<Food> listAll() {
        return repo.findAll();
    }

    public void save(Food food) {
        repo.save(food);
    }

    public Food get(String foodName) {
        return repo.findById(foodName).get();
    }

    public void delete(String foodName) {
        repo.deleteById(foodName);
    }
}
