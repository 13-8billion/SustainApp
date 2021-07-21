package sustain.project.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AddTransport")
public class AddTransport  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ID")
    private int ID;
    @Column(name = "type")
    private String type;
    @Column(name = "username")
    private String username;
    @Column(name = "distance")
    private double distance;
    @Column(name = "res")
    private double res;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id //  mySQL primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

}