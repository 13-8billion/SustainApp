package sustain.project.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import sustain.project.interfaces.EmailConstraint;
import sustain.project.interfaces.UsernameConstraint;
import sustain.project.service.UserService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
@Configurable
@Entity // mySQL entity
@Table(name = "User")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // mySQL primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private String userID;
    @NotBlank(message = "*Username field cannot be empty")
//    @UsernameConstraint
    @Column(name = "username")
    private String username;
    //    @EmailConstraint
    @NotBlank(message = "*Email field cannot be empty")
    @Email(message = "*Invalid email")
    @Column(name = "email")
    private String email;
    @Column(name = "location")
    private String location;
    @NotBlank(message = "*Password field cannot be empty!")
    @Size(min = 8, max = 100, message = "*Password must be at least 8 characters")
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
