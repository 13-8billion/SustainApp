package sustain.project.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity // mySQL entity
@Table(name = "User")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // mySQL primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private String userID;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "location")
    private String location;
    @Column(name = "password")
    private String password;

    public User() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


}
