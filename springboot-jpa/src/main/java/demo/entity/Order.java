package demo.entity;

import javax.persistence.*;

@Entity(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "contents")
	private String contents;
	@Column(name = "customer_id")
	private long customerId;

	protected Order() {}

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