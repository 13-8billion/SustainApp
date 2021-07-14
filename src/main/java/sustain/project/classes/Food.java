package sustain.project.classes;

import javax.persistence.*;

@Entity
@Table(name = "Food")
public class Food {

    // VARIABLES

    @Column(name = "foodID")
    private int foodID;
    @Column(name = "foodName")
    private String foodName;
    @Column(name = "co2g")
    private double co2g;


    // CONSTRUCTORS

    public Food(int foodID, String foodName, double co2g) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.co2g = co2g;
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }


    public Food() {

    }

    // SETTERS AND GETTERS

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Id //  mySQL primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodName")
    public String getFoodName() {
        return foodName;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setCo2g(double co2g) {
        this.co2g = co2g;
    }

    public double getCo2g() {
        return co2g;
    }

    @Override
    public String toString() {
        return foodName + ", " + co2g;
    }
}



