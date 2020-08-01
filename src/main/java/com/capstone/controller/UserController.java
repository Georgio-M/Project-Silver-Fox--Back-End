package com.capstone.controller;
import com.capstone.entity.Users;
import com.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/submitUserDetails", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)

	public void submitUserDetails(@RequestBody Users users) {
		userRepo.save(users);
	}

	@RequestMapping(value = "/findUserById",
			produces =MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)

	@ResponseBody
	ResponseEntity<Optional<Users>> findUser(String email){
		Optional<Users> user = userRepo.findByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/logIn", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)

	@ResponseBody
	ResponseEntity<Optional<Users>>findLogin(String email){
		Optional<Users> users = userRepo.findByEmail(email);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value="/login",
			consumes= MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)

	@ResponseBody	public ResponseEntity<Optional<Users>> login(@RequestBody Users users) {Optional<Users> s = userRepo.findByEmail(users.getEmail());
		if(s.isPresent() && s.get().getPassword().equals(users.getPassword())) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);}


	@RequestMapping(value ="/findAll",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Users>> findAll() {
		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
	}
}




