package com.zkteco.service;

import java.time.LocalDate;
import java.util.List;

import com.zkteco.entity.Result;
import com.zkteco.entity.User;
import com.zkteco.exceptions.UserException;

public interface UserService {

	public Result saveUser(User user);
	
	public Result saveBatchUsers(List<User> users);

	public Result updateUserById(String userId, User user) throws UserException;
	
	public Result fetchUserByIdorEmailorPhone(String userId, String email, String phone) throws UserException;
	
	public Result fetchAllUsers() throws UserException;
	
	public Result fetchAllUsersBetweenDates(LocalDate startDate, LocalDate EndDate) throws UserException;
	
	public Result deleteUserById(String userId) throws UserException;
}
