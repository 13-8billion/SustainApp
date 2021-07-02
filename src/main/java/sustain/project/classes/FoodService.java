package sustain.project.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sustain.project.interfaces.FoodRepo;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private static FoodRepo repo;
    private static String foodName;
    private static double grams;

    public static List<Food> listAll() {
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

    // ADD FOOD TO ARRAY

//    public static ArrayList<Object> addFoodMethod(String foodName, double grams) {
//
//        repo.findAll() =
//
//        ArrayList<Object> foodList = new ArrayList<>();
//        foodList.add(new Food(foodName, grams));
//
//        return foodList;
//    }

    // CALC CO2

//    public static double calcFoodCo2(String foodN, double g) {
//
//        double res = 0;
//
////        ArrayList<Food> foodDB = new ArrayList<>((Collection<? extends Food>) Arrays.asList(listAll()));
//
//        for (Food food : foodDB) {
//
//            if (food.getFoodName().equals(foodN)) {
//
//                double oneG = food.getCo2g() / 100;
//                res = g * oneG;
//            }
//        }
//        return res;
//    }
}

