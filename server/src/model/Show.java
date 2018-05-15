package model;

import javax.persistence.*;

@Entity
@Table(name ="event")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    public Show(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Show(int id,String name, String description) {
        this(name,description);
        this.id = id;

    }

    public Show() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
