package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sustain.project.classes.Food;
import sustain.project.interfaces.FoodRepo;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepo repo;
    private String foodName;
    private double grams;

    public List<Food> listAll() {
        return repo.findAll();
    }

    public void save(Food food) {
        repo.save(food);
    }

    public Food get(String username) {
        return repo.findById(username).get();
    }

    public void delete(String foodName) {
        repo.deleteById(foodName);
    }

    }


