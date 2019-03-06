package com.example.TestCreateProject.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestCreateProject.Model.UserComment;

@Repository
public class UserCommentRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<UserComment> GetStatusReport(){
		List<UserComment> usercomments = new ArrayList<UserComment>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(
				"SELECT user.id_user,user_comment.id_user_comment,user.name,user.penname,comment.collect_comment,user.avatar\r\n" + 
				"FROM ((user_comment INNER JOIN user ON user_comment.id_user= user.id_user)\r\n" + 
				"                    INNER JOIN comment ON user_comment.id_comment = comment.id_comment)\r\n" + 
				"                    WHERE user_comment.status=1 AND user.status=0");
		for(Map<String,Object> row:rows) {
			UserComment usercomment = new UserComment();
			usercomment.setIdUser((int) row.get("id_user"));
			usercomment.setIdUserComment((int) row.get("id_user_comment"));
			usercomment.setName((String) row.get("name"));
			usercomment.setPenname((String) row.get("penname"));
			usercomment.setCollectComment((String) row.get("collect_comment"));
			usercomment.setAvatar((String) row.get("avatar"));
			usercomments.add(usercomment);
		}
		return usercomments;
	}
	
	public int Cancelban(int id) {
		int update = jdbcTemplate.update
				("UPDATE user_comment SET status = 0 WHERE user_comment.id_user_comment = ?",id);
		return 1;
	}
	
	public int Banuser(UserComment usercomment) {
		int update = jdbcTemplate.update
				("UPDATE user,user_comment SET user.status =1,user_comment.status=2 WHERE user.id_user=? AND user_comment.id_user_comment=?"
				,usercomment.getIdUser(),usercomment.getIdUserComment());
		return 1;
	}
}
