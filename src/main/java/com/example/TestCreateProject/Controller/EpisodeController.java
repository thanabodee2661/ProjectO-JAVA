package com.example.TestCreateProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestCreateProject.Model.Episode;
import com.example.TestCreateProject.Service.EpisodeService;

@RestController
@CrossOrigin(origins = "*")
public class EpisodeController {
	
	@Autowired
	private EpisodeService episodeService;
	
	@GetMapping("/episodes/{id}")
	public List<Episode>  getEpisodeByID(@PathVariable("id") int id_book) {
		return episodeService.getEpisodeByID(id_book);
	}
	
	@GetMapping("/episode/{id}")
	public Episode getEpisodeByIDEpisode(@PathVariable("id") int id_episode) {
		return episodeService.getEpisodeByIDEpisode(id_episode);
	}
	
	@PostMapping("/episode")
	public int createEpisode(@RequestBody Episode episode ) {
		return episodeService.createEpisode(episode);
	}
	
	@PutMapping("/episode")
	public int updateEpisode(@RequestBody Episode episode ) {
		return episodeService.updateEpisode(episode);
	}
}
