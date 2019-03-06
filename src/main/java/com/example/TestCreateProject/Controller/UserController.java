package com.example.TestCreateProject.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.TestCreateProject.Model.User;
import com.example.TestCreateProject.Security.JwtGenerator;
import com.example.TestCreateProject.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private JwtGenerator jwtGenerator;

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@PostMapping("/user")
	public int createUser(@RequestParam("name") String name, @RequestParam("lastname") String lastname,
			@RequestParam("birthday") String birthday, @RequestParam("avatar") String avatar,
			@RequestParam("email") String email, @RequestParam("panname") String panname,
			@RequestParam("password") String password,
			@RequestParam(name = "file", required = false) MultipartFile file) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String[] b = birthday.split("-");
		Date b_day = df.parse("" + (Integer.parseInt(b[0]) + 543) + "-" + b[1] + "-" + b[2]);
		User user = new User();
		user.setName(name);
		user.setLastname(lastname);
		user.setBirthday(b_day);
		user.setEmail(email);
		user.setPanname(panname);
		user.setPassword(password);
		if (file != null) {
			user.setAvatar(avatar);
			int id_user = userService.createUser(user);
			if (id_user > 0) {
				int uImg = userService.uploadImg(file, id_user);
				if (uImg > 0) {
					return id_user;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} else {
			int id_user = userService.createUser(user);
			if (id_user > 0) {
				return id_user;
			} else {
				return 0;
			}
		}

	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json")
	public HashMap<String, Object> login(@RequestBody User user) {

		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getApplication_date());
		List<User> getUser = userService.findByEmail(user);

		if (getUser.size() == 1) {
			String jws = jwtGenerator.generate(getUser.get(0));
			System.out.println(jws);
			HashMap<String, Object> map = new HashMap<>();
			map.put("auth", jws);
			return map;

		} else {
			HashMap<String, Object> map = new HashMap<>();
			map.put("auth", null);

			return map;
		}

	}
	
	@PostMapping("/userfavorbook")
	public int createUserFavorBook(@RequestParam("id_book") int id_book, @RequestParam("id_user") int id_user) {
		System.out.println("105");
		return userService.createUserFavorBook(id_book, id_user);
	}
	
	@DeleteMapping("/userfavorbook/{id_user}/{id_book}")
	public int deleteUserFavorBook(@PathVariable("id_book")int id_book, @PathVariable("id_user")int id_user) {
		System.out.println("113");
		return userService.deleteUserFavorBook(id_book, id_user);
	}
	
	@GetMapping("/userfavorbook/{id_user}")
	public List<Map<String, Object>> getFavorBook(@PathVariable("id_user") int id_user){
		System.out.println("119");
		return userService.getFavorBook(id_user);
	}
}
