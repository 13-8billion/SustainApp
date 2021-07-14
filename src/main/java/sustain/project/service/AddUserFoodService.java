package sustain.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import sustain.project.classes.AddUserFood;
import sustain.project.classes.Food;
import sustain.project.interfaces.AddUserFoodRepo;

import java.util.ArrayList;
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

    // ADD FOOD TO ARRAY

//   private static  ArrayList<Object> foodList = new ArrayList<>();
//
//    static ArrayList<Object> addFood(String foodName, double grams)
//    {
//        foodList.add(new Food(foodName, grams));
//        return foodList;
//
//    }


//    // CALC CO2
//    static double calcCo2(String foodN, double g)
//    {
//        ArrayList<Object> foodList = new ArrayList<>();
//        foodList.add(new Food(foodN, g));
//
//        ArrayList<Food> foodDB= new ArrayList<>();
//        Food f = new Food();
//        double oneG = 0;
//        double res = 0;
//
//        for (int i = 0; i < foodDB.size(); i++)
//        {
//
//            if(foodDB.get(i).getFoodName().equals(foodN))
//            {
//
//                oneG = foodDB.get(i).getCo2g() / 100;
//                res = g * oneG;
//
//            }
//        }
//        return res;
//    }

//    public static ArrayList<Object> addFoodMethod(String foodName, double grams) {
//
//        repo.findAll() =
//
//        ArrayList<Object> foodList = new ArrayList<>();
//        foodList.add(new Food(foodName, grams));
//
//        return foodList;
//    }
//
//    // CALC CO2
//
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


