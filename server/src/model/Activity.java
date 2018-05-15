package model;

import javax.persistence.*;

@Entity
@Table(name ="history")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="id_user")
    private int userId;
    @Column(name ="id_show")
    private int showId;

    public Activity(int id, int userId, int showId) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
    }

    public Activity(int userId, int showId) {
        this.userId = userId;
        this.showId = showId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }
}
