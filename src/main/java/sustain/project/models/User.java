package sustain.project.models;

import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.*;
@Configurable
@Entity // mySQL entity
@Table(name = "User")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // mySQL primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userID;
    @NotBlank(message = "*Username field cannot be empty")
    @Size(min = 3, max = 15, message = "*Username must be between 3-15 characters")
    @Column(name = "username")
    private String username;
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
    @Column(name = "profilePic", length = 64)
    private String profilePic;

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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

    public void setProfilePic(String fileName) {
    }
    public String getProfilePic() {
        return profilePic;
    }

    @Transient
    public String getProfilePicImagePath() {
        if (profilePic == null || userID == 0) return null;

        return "/profilePics/" + userID + "/" + profilePic;
    }
}
