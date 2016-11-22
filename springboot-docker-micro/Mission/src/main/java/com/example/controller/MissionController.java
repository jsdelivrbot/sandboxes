package com.example.controller;

import com.example.model.Mission;
import com.example.repo.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public class MissionController {

	@Autowired
	MissionRepository missionRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Mission create(@RequestBody Mission mission) {
		Mission result = missionRepository.save(mission);
		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value="/{missionId}")
	public Mission get(@PathVariable String missionId) {
		return missionRepository.findOne(missionId);
	}

	@RequestMapping(method = RequestMethod.GET, value="/")
	public List<Mission> getAll() {
		return missionRepository.findAll();
	}
}
