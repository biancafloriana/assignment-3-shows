package model;

import javax.persistence.*;

@Entity
@Table(name ="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name ="id_user")
    private  int userId;

    @Column(name ="id_show")
    private  int showId;

    @Column
    private  String text;

    public Comment(int id ,int userId, int showId, String text) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.text = text;
    }

    public Comment(int userId, int showId, String text) {
        this.userId = userId;
        this.showId = showId;
        this.text = text;
    }

    public Comment() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
