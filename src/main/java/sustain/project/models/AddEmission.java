package sustain.project.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "AddEmission")
public class AddEmission implements Serializable {
    private static final long serialVersionUID = 1L;

    // VARIABLES

    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "type")
    private String type;
    @Column(name = "res")
    private double res;
    @Column(name = "quantity")
    private double quantity;


    @Id //  mySQL primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}