package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="movie")
@PrimaryKeyJoinColumn(name="id")
public class SportEvent extends Show {

    @Column
    private String team1;

    @Column
    private String team2;

    public SportEvent(String name, String description, String team1, String team2) {
        super(name, description);
        this.team1 = team1;
        this.team2 = team2;
    }

    public SportEvent(int id, String name, String description, String team1, String team2) {
        super(id, name, description);
        this.team1 = team1;
        this.team2 = team2;
    }

    public SportEvent() {

    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }
}
