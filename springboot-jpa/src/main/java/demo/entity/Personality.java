package demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Personality {

	@Id
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	protected Personality() {}

	@ManyToMany
	@JoinTable(name="CustomerPersonality")
	Collection<Customer> customers;

	@Override
	public String toString() {
		return String.format(
				"Personality[id=%d, name='%s' description='%s']",
				id, name, description);
	}
}
