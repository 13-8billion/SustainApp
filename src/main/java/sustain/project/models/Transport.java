package sustain.project.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Transport")
public class Transport  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ID")
    private int ID;
    @Column(name = "type")
    private String type;
    @Column(name = "co2km")
    private double co2km;

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

    public double getCo2km() {
        return co2km;
    }

    public void setCo2km(double co2km) {
        this.co2km = co2km;
    }

}