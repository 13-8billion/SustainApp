package sustain.project.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "HouseEnergyTotal")
public class HouseEnergyTotal implements Serializable {
    private static final long serialVersionUID = 1L;

    // VARIABLES

    @Column(name = "ID")
    private int ID;
    @Column(name = "username")
    private String username;
    @Column(name = "total")
    private double total;
    @Column(name = "date")
    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}