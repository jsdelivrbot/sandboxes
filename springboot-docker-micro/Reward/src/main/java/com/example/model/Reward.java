package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by dustinstanley on 11/22/16.
 */
@Document(collection="rewards")
public class Reward {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public int getPointCost() {
		return pointCost;
	}

	public void setPointCost(int pointCost) {
		this.pointCost = pointCost;
	}

	private String name;
	private String description;
	private int pointCost;
}
