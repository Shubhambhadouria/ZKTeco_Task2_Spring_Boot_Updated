package com.zkteco.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zkteco.entity.Result;
import com.zkteco.entity.User;
import com.zkteco.exceptions.UserException;
import com.zkteco.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/user")
	public Result saveUserHandler(@RequestBody User user){
		LOGGER.info("Inside saveUserController Method");
		return userService.saveUser(user);
	}
	
	@PostMapping("/users")
	public Result saveBatchUserHandler(@RequestBody List<User> users) {
		LOGGER.info("Inside saveBatchUserController Method");
		return userService.saveBatchUsers(users);
	}
	
	@PutMapping("/user/{id}")
	public Result updateUserByIdHandler(@PathVariable("id") String userId,
									  @RequestBody User user) throws UserException {
		LOGGER.info("Inside updateUserByIdController Method");
		return userService.updateUserById(userId,user);
	}
	
	@GetMapping("/search")
	public Result getByIdorEmailorPhoneHandler(@RequestParam(required = false) String userId,
											 @RequestParam(required = false) String email,	
											 @RequestParam(required = false) String phone) throws UserException {
		LOGGER.info("Inside getByIdorEmailorPhoneController Method");
		return userService.fetchUserByIdorEmailorPhone(userId,email,phone);	
	}
	
	@GetMapping("/allUsers")
	public Result fetchAllUsersHandler() throws UserException {
		LOGGER.info("Inside fetchAllUsersController Method");
		return userService.fetchAllUsers();
	}
	
	@GetMapping("/users/{start}/{end}")
	public Result fetchUsersByDateHandler(@PathVariable("start") LocalDate startDate,
											  @PathVariable("end") LocalDate endDate) throws UserException {
		LOGGER.info("Inside fetchUsersByDateController Method");
		return userService.fetchAllUsersBetweenDates(startDate, endDate);
	}
	
	@DeleteMapping("/user/{id}")
	public Result deleteUserById(@PathVariable("id") String userId) throws UserException {
		LOGGER.info("Inside deleteUserByIdController Method");
		return userService.deleteUserById(userId);
	}
	
}
