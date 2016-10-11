package demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "CustomerPersonality",
            joinColumns = @JoinColumn(name = "CustomerId"),
            inverseJoinColumns = @JoinColumn(name = "PersonalityId")
    )
    private Collection<Personality> personalities;

    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, Collection<Personality> personalities) {
        this(firstName, lastName);
        this.personalities = personalities;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Collection<Personality> getPersonalities() {
        return personalities;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}