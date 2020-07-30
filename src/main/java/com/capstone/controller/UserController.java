package com.capstone.controller;

import java.util.List;
import java.util.Optional;

import com.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.entity.User;


@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository userRepo;
		
	@RequestMapping(value = "/submitStudentDetails", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	
	public void submitStudentDetails(@RequestBody User user) {
		userRepo.save(user);

	}
	
	@RequestMapping(value = "/findStudentById",
			produces =MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
			
			@ResponseBody
			 ResponseEntity<Optional<User>>findStudent(String email){
		Optional<User> student = userRepo.findById(email);
		return new ResponseEntity<>(student, HttpStatus.OK);
			
			}
	
//	Number 19 starts here
	@RequestMapping(value = "/logIn", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	
	@ResponseBody
	ResponseEntity<Optional<User>>findLogin(String logName){
		Optional<User> user = userRepo.findById(logName);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/login",
			consumes= MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)	
	
			@ResponseBody	public ResponseEntity<Optional<User>> login(@RequestBody User user) {Optional<User> s = userRepo.findById(user.getEmail());
			if(s.isPresent() && s.get().getPassWord().equals(user.getPassWord())) {
			return new ResponseEntity<>(s, HttpStatus.OK); }return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);}
	


// Number 20 starts chnage type to list so i can use an array
@RequestMapping(value ="/findAll",
produces = MediaType.APPLICATION_JSON_VALUE,
method = RequestMethod.GET)
@ResponseBody
public ResponseEntity<List<User>> findAll() {
return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
}
}


