package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="theatre")
@PrimaryKeyJoinColumn(name="id")
public class Theatre extends Show {

    @Column
    private String actors;


    public Theatre(String name, String description, String actors) {
        super(name, description);
        this.actors = actors;
    }

    public Theatre(int id, String name, String description, String actors) {
        super(id, name, description);
        this.actors = actors;
    }

    public Theatre() {

    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
