package sustain.project.classes;

import javax.persistence.*;

@Entity // so java knows it's an entity(obvs)
@Table(name = "User")
public class User {

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

    @Id // so mySQL knows this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
