package sustain.project.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AddFlight")
public class AddFlight implements Serializable {
    private static final long serialVersionUID = 1L;

    // VARIABLES

    @Column(name = "ID")
    private int ID;
    @Column(name = "username")
    private String username;
    @Column(name = "res")
    private double res;
    @Column(name = "distance")
    private double distance;

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

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}