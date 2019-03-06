package com.example.TestCreateProject.Model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Book {
	private int id_book;
	private String name_fiction;
	private Date create_day;
	private String preview;
	private int id_user;
	private String img_book;
	private List<Map<String, Object>> typebook;
	private int view;
	private List<Map<String, Object>> episode;
	private String panname;
	private int count_episode;
	public int getId_book() {
		return id_book;
	}
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}
	public String getName_fiction() {
		return name_fiction;
	}
	public void setName_fiction(String name_fiction) {
		this.name_fiction = name_fiction;
	}
	public Date getCreate_day() {
		return create_day;
	}
	public void setCreate_day(Date create_day) {
		this.create_day = create_day;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getImg_book() {
		return img_book;
	}
	public void setImg_book(String img_book) {
		this.img_book = img_book;
	}
	public List<Map<String, Object>> getTypebook() {
		return typebook;
	}
	public void setTypebook(List<Map<String, Object>> typebook) {
		this.typebook = typebook;
	}
	public int getView() {
		return view;
	}
	public void setView(int bigDecimal) {
		this.view = bigDecimal;
	}
	public List<Map<String, Object>> getEpisode() {
		return episode;
	}
	public void setEpisode(List<Map<String, Object>> episode) {
		this.episode = episode;
	}
	public String getPanname() {
		return panname;
	}
	public void setPanname(String panname) {
		this.panname = panname;
	}
	public int getCount_episode() {
		return count_episode;
	}
	public void setCount_episode(int count_episode) {
		this.count_episode = count_episode;
	}


}
