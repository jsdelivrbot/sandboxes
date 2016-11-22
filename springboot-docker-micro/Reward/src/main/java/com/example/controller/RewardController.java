package com.example.controller;

import com.example.model.Reward;
import com.example.repo.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by dustinstanley on 11/22/16.
 */
public class RewardController {

	@Autowired
	RewardRepository rewardRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Reward create(@RequestBody Reward reward) {
		Reward result = rewardRepository.save(reward);
		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value="/{rewardId}")
	public Reward get(@PathVariable String rewardId) {
		return rewardRepository.findOne(rewardId);
	}

	@RequestMapping(method = RequestMethod.GET, value="/")
	public List<Reward> getAll() {
		return rewardRepository.findAll();
	}
}
