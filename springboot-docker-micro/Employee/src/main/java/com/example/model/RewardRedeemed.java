package com.example.model;


import java.util.Date;

public class RewardRedeemed {

	public String getRewardId() {
		return rewardId;
	}

	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
	}

	public Date getRedeemedOn() {
		return redeemedOn;
	}

	public void setRedeemedOn(Date redeemedOn) {
		this.redeemedOn = redeemedOn;
	}

	public int getPointCost() {
		return pointCost;
	}

	public void setPointCost(int pointCost) {
		this.pointCost = pointCost;
	}

	private String rewardId;
	private Date redeemedOn;
	private int pointCost;


}
