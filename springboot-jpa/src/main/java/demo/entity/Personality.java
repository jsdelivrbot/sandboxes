package demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Personality {

    public static Personality SCHIZOPHRENIC = new Personality(2, "Schizophrenic", "Stay Away");
    public static Personality EMO = new Personality(3, "Emo", "Listens to Elliot Smith");

    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    private Personality(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    protected Personality() {
    }

    @ManyToMany
    @JoinTable(name = "CustomerPersonality")
    Collection<Customer> customers;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format(
                "Personality[id=%d, name='%s' description='%s']",
                id, name, description);
    }
}
