package com.example.TestCreateProject.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestCreateProject.Model.Episode;

@Repository
public class EpisodeRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Episode> getEpisodeByID(int id_book) {
		String sql = "SELECT * FROM episode WHERE id_book = ? ";
		List<Episode> episodes = new ArrayList<Episode>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { id_book });

		for (Map<String, Object> row : rows) {
			Episode episode = new Episode();
			episode.setId_episode((int) row.get("id_episode"));
			episode.setName_episode((String) row.get("name_episode"));
			episode.setContent((String) row.get("content"));
			episode.setView((int) row.get("view"));
			episode.setId_book((int) row.get("id_book"));
			episodes.add(episode);
		}
		return episodes;
	}
	
	public Episode getEpisodeByIDEpisode(int id_episode) {
		String sql = "SELECT * FROM episode WHERE id_episode = ? ";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { id_episode });

		Episode episode = new Episode();
		for (Map<String, Object> row : rows) {
			episode.setId_episode((int) row.get("id_episode"));
			episode.setName_episode((String) row.get("name_episode"));
			episode.setContent((String) row.get("content"));
			episode.setView((int) row.get("view"));
			episode.setId_book((int) row.get("id_book"));
		}
		return episode;
	}


	public int createEpisode(Episode episode) {
		String sql = "INSERT INTO `episode`(`name_episode`, `content`, `id_book`) VALUES (?,?,?)";

		return jdbcTemplate.update(sql, episode.getName_episode(), episode.getContent(), episode.getId_book());
	}
	
	public int updateEpisode(Episode episode) {
		String sql = "UPDATE episode SET name_episode = ?, content = ? WHERE id_episode = ?";

		return jdbcTemplate.update(sql, episode.getName_episode(), episode.getContent(), episode.getId_episode());
	}
	
	public List<Episode> getEpisodeByIDOrder(int id_book, int start) {
		String sql = "SELECT * FROM episode e WHERE e.id_book = ?\r\n" + 
				"ORDER BY e.id_episode DESC LIMIT ?, 5";
		List<Episode> episodes = new ArrayList<Episode>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { id_book, start });

		for (Map<String, Object> row : rows) {
			Episode episode = new Episode();
			episode.setId_episode((int) row.get("id_episode"));
			episode.setName_episode((String) row.get("name_episode"));
			episode.setContent((String) row.get("content"));
			episode.setView((int) row.get("view"));
			episode.setId_book((int) row.get("id_book"));
			episodes.add(episode);
		}
		return episodes;
	}
	
	public int updateEpisodeView(int view, int id_episode) {
		String sql = "UPDATE episode SET view = ? WHERE id_episode = ?";

		return jdbcTemplate.update(sql, view, id_episode);
	}
}
