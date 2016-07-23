package demo;

import javax.persistence.*;

@Entity(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name = "contents")
	private String contents;
	@Column(name = "customer_id")
	private long customerId;

	public Order(long customerId, String contents) {
		this.customerId = customerId;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, contents='%s']",
				id, contents);
	}

}