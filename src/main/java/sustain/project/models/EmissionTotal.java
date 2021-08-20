package sustain.project.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "EmissionTotal")
public class EmissionTotal implements Serializable {
    private static final long serialVersionUID = 1L;

    // VARIABLES

    @Column(name = "ID")
    private int ID;
    @Column(name = "username")
    private String username;
    @Column(name = "totalCo2")
    private double totalCo2;
    @Column(name = "emissionType")
    private String emissionType;
    @Column
    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


    // CONSTRUCTORS

    public EmissionTotal(int ID, String username) {
        this.ID = ID;
        this.username = username;
    }


    public EmissionTotal(double totalCo2) {
        this.totalCo2 = totalCo2;

    }

    public EmissionTotal() {

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

    public String getEmissionType() {
        return emissionType;
    }

    public void setEmissionType(String emissionType) {
        this.emissionType = emissionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}