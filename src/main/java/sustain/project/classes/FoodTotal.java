package sustain.project.classes;

import javax.persistence.*;

@Entity
@Table(name = "FoodTotal")
public class FoodTotal {

    // VARIABLES

    @Column(name = "ID")
    private int ID;
    @Column(name = "username")
    private String username;
    @Column(name = "totalCo2")
    private double totalCo2;


    // CONSTRUCTORS

    public FoodTotal(int ID, String username, double Totalco2) {
        this.ID = ID;
        this.username = username;
        this.totalCo2 = totalCo2;
    }

    public FoodTotal(String username) {
        this.username = username;
    }


    public FoodTotal() {

    }

    // SETTERS AND GETTERS

    @Id //  mySQL primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getTotalCo2() {
        return totalCo2;
    }

    public void setTotalCo2(double totalCo2) {
        this.totalCo2 = totalCo2;
    }

}