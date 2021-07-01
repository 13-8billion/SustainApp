package sustain.project.classes;

import javax.persistence.*;

@Entity
@Table(name = "Food")
public class Food {
    private int foodID;
    private String foodName;
    private double co2g;

    public Food(int foodID, String foodName, double co2g) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.co2g = co2g;
    }

    public Food() {

    }

    @Id // so mySQL knows this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodID")
    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }


    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setCo2g(double co2g) {
        this.co2g = co2g;
    }

    public double getCo2g() {
        return co2g;
    }

    @Override
    public String toString() {
        return foodName;
    }
}

