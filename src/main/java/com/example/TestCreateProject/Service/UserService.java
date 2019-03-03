package com.example.TestCreateProject.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.TestCreateProject.Model.User;
import com.example.TestCreateProject.Repository.UserRepo;

@Service
public class UserService {

	// private final Path rootLocation =
	// Paths.get("src\\main\\resources\\static\\img");
	private String rootLocation = "src\\main\\resources\\static\\img\\";

	@Autowired
	private UserRepo userRepo;
	

	public List<User> getAllUser() {
		return userRepo.getAllUser();
	}

	public int createUser(User user) {
		return userRepo.createUser(user);
	}

	public int uploadImg(MultipartFile file, int id_user) {

		try {
			Path path = Paths.get(rootLocation + id_user);
			byte[] bytes = file.getBytes();
			File folder = new File(rootLocation + id_user);

			if (!folder.exists()) {
				folder.mkdirs();
				Files.write(path.resolve(file.getOriginalFilename()), bytes);
			} else {
				Files.write(path.resolve(file.getOriginalFilename()), bytes);
			}

			return 1;
		} catch (Exception e) {
			System.out.println("upload file Fail.");
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<User> findByEmail(User user) {
		return userRepo.findByEmail(user);
		
	}
	
}
