package com.example.TestCreateProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TestCreateProject.Model.UserComment;
import com.example.TestCreateProject.Repository.UserCommentRepo;

@Service
public class UserCommentService {

	 @Autowired
	 private UserCommentRepo usercommentrepo;
	 
	 public List<UserComment> GetCommentReport(){
		 return usercommentrepo.GetStatusReport();
	 }
	 
	 public int Cancelban(int id) {
		 return usercommentrepo.Cancelban(id);
	 }
	 
	 public int Banuser(UserComment usercomment) {
		 return usercommentrepo.Banuser(usercomment);
	 }
}
