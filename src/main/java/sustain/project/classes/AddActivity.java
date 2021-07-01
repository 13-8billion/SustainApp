package sustain.project.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddActivity {

    private int activityID;
    private String activityType;
    private String date;

    public AddActivity(int activityID, String activityType, String date) {
        this.activityID = activityID;
        this.activityType = activityType;
        this.date = date;
    }

    public AddActivity() {

    }

    @Id // so mySQL knows this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }


    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
