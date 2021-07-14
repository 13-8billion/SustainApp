package sustain.project.classes;

import javax.persistence.*;

@Entity // so java knows it's an entity(obvs)
@Table(name = "AddUserFood")
public class AddUserFood {

    @Column(name = "ID")
    private String ID;
    @Column(name = "username")
    private String username;
    @Column(name = "foodName")
    private String foodName;
    @Column(name = "grams")
    private double grams;
    @Column(name = "res")
    private double res;

    public AddUserFood() {
    }

    @Id // so mySQL knows this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    public void setRes(double res){
        this.res = res;
    }
    public double getRes() {
        return res;
    }

}
