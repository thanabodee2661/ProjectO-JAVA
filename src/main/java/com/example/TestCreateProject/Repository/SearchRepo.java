package com.example.TestCreateProject.Repository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestCreateProject.Model.Searchall;

@Repository
public class SearchRepo{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Searchall> GetAllFiction(){
		List<Searchall> searchalls = new ArrayList<Searchall>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList("SELECT book.name_fiction,type.name_type,book.preview,sum(DISTINCT episode.view),COUNT(DISTINCT comment.id_comment),COUNT(DISTINCT likely.id_user)\r\n" + 
				"FROM  episode ,likely,comment,user_comment,type_book,type,user,book\r\n" + 
				"WHERE   type_book.id_type = type.id_type\r\n" + 
				"AND episode.id_book = book.id_book\r\n" + 
				"AND user_comment.id_book = book.id_book\r\n" + 
				"AND user_comment.id_comment = comment.id_comment\r\n" + 
				"AND likely.id_book = book.id_book\r\n" + 
				"GROUP BY book.name_fiction\r\n" + 
				"ORDER BY episode.view DESC");
		for(Map<String,Object> row:rows) {
			Searchall searchall = new Searchall();
			searchall.setNameFiction((String) row.get("name_fiction"));
			searchall.setType((String) row.get("name_type"));
			searchall.setPreview((String) row.get("preview"));
			searchall.setSum((BigDecimal) row.get("sum(DISTINCT episode.view)"));
			searchall.setTotalcomment((long) row.get("COUNT(DISTINCT comment.id_comment)"));
			searchall.setTotallike((long) row.get("COUNT(DISTINCT likely.id_user)"));
			searchalls.add(searchall);
		}	
		return searchalls;
	}

}
