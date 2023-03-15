package com.zkteco.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkteco.entity.Result;
import com.zkteco.entity.User;
import com.zkteco.exceptions.UserException;
import com.zkteco.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	public Result saveUser(User user) {
		
		// Validation For Id
		
		if(user.getUserId().equalsIgnoreCase("") || user.getUserId().equalsIgnoreCase(null)) {
			return new Result("UIE","Please Enter UserId",null);
		}
		
		if(!(user.getUserId().length()<37 && user.getUserId().length()>0)) {
			return new Result("UIL","UserId length must not be graeter than 36 characters.",null);
		}
		
		if(userRepository.findById(user.getUserId()).isPresent()) {
			return new Result("UIP","UserId is already present",null);
		}
		
		
		// Validation For Name
		
		if(user.getFirstName().equals("")) {
			return new Result("FNE","Please Enter First Name",null);
		}
		
		if(!(user.getFirstName().length()<51 && user.getFirstName().length()>0)) {
			return new Result("FNL","User's First Name length should not be greater than 50 characters.",null);
		}
		
		if(!(user.getLastName().length()<50 && user.getFirstName().length()>0)) {
			return new Result("LNL","Please Enter First Name",null);
		}
		
		
		// Validation For Gender
		
		if(!user.getGender().matches("(?:[M|F|O])")) {
			return new Result("G","Please Enter Gender either M, F AND O in single character",null);
		}
		
		
		// Validation For Email
		
		if(user.getEmail().equals("")) {
			return new Result("EE","Please Enter Email",null);
		}
		
		if(!user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}")) {
			return new Result("ER","Please Enter Email in Correct Format",null);
		}
		
		if(userRepository.findByEmail(user.getEmail())!=null) {
			return new Result("EAP","Email is Already Present",null);
		}
		
		
		// Validation For Phone
		
		if(user.getPhone().equals("")) {
			return new Result("PE","Please Enter Phone Number",null);
		}
		
		if(!user.getPhone().matches("[+]+[0-9]{2}+[-]+[0-9]{10}")) {
			return new Result("PR","Please Enter Correct Format for Phone For E.g..+91-7974123456 ",null);
		}
		
		if(userRepository.findByPhone(user.getPhone())!=null) {
			return new Result("PAP","Phone Number is Already Present",null);
		}
		
		
		// Validation For Password
		
		if(user.getPassword().equals("")) {
			return new Result("PE","Please Enter  Password",null);
		}
		
		if(!user.getPassword().matches("^(?=.*[A-Z])[A-Za-z0-9].{8,16}")) {
			return new Result("E","Please Enter Correct Format for Password Like : A password must have at "
					+ "least 8 characters, consists of only letters and digits, must "
					+ "contain at least two digits & at least "
					+ "one uppercase character",null);
		}
		
		userRepository.save(user);
		return new Result("OK","User Entered Successfully!",user);
		
	}

	@Override
	public Result saveBatchUsers(List<User> users) {
		
		for(int i=0; i<users.size(); i++) {
			
			// Validation For Id
			
			if(users.get(i).getUserId().equalsIgnoreCase("") || users.get(i).getUserId().equalsIgnoreCase(null)) {
				return new Result("UIE","Please Enter UserId",null);
			}
			
			if(!(users.get(i).getUserId().length()<37 && users.get(i).getUserId().length()>0)) {
				return new Result("UIL","UserId length must not be graeter than 36 characters.",null);
			}
			
			if(userRepository.findById(users.get(i).getUserId()).isPresent()) {
				return new Result("UIP","UserId is already present",null);
			}
			
			
			// Validation For Name
			
			if(users.get(i).getFirstName().equals("")) {
				return new Result("FNE","Please Enter First Name",null);
			}
			
			if(!(users.get(i).getFirstName().length()<51 && users.get(i).getFirstName().length()>0)) {
				return new Result("FNL","User's First Name length should not be greater than 50 characters.",null);
			}
			
			if(!(users.get(i).getLastName().length()<50 && users.get(i).getFirstName().length()>0)) {
				return new Result("LNL","Please Enter First Name",null);
			}
			
			
			// Validation For Gender
			
			if(!users.get(i).getGender().matches("(?:[M|F|O])")) {
				return new Result("G","Please Enter Gender either M, F AND O in single character",null);
			}
			
			
			// Validation For Email
			
			if(users.get(i).getEmail().equals("")) {
				return new Result("EE","Please Enter Email",null);
			}
			
			if(!users.get(i).getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}")) {
				return new Result("ER","Please Enter Email in Correct Format",null);
			}
			
			if(userRepository.findByEmail(users.get(i).getEmail())!=null) {
				return new Result("EAP","Email is Already Present",null);
			}
			
			
			// Validation For Phone
			
			if(users.get(i).getPhone().equals("")) {
				return new Result("PE","Please Enter Phone Number",null);
			}
			
			if(!users.get(i).getPhone().matches("[+]+[0-9]{2}+[-]+[0-9]{10}")) {
				return new Result("PR","Please Enter Correct Format for Phone For E.g..+91-7974123456 ",null);
			}
			
			if(userRepository.findByPhone(users.get(i).getPhone())!=null) {
				return new Result("PAP","Phone Number is Already Present",null);
			}
			
			
			// Validation For Password
			
			if(users.get(i).getPassword().equals("")) {
				return new Result("PE","Please Enter  Password",null);
			}
			
			if(!users.get(i).getPassword().matches("^(?=.*[A-Z])[A-Za-z0-9].{8,16}")) {
				return new Result("E","Please Enter Correct Format for Password Like : A password must have at "
						+ "least 8 characters, consists of only letters and digits, must "
						+ "contain at least two digits & at least "
						+ "one uppercase character",null);
			}
			
			
		}
		userRepository.saveAll(users);
		return new Result("OK","Batch Users Saved Successfully",users);
	}

	@Override
	public Result updateUserById(String userId, User user) throws UserException {
		User user1 =  userRepository.findById(userId).get();
		if(user1!=null) {
			
			//////////////////-----VALIDATIONS STARTING FROM HERE--------////////////////////
			
			
			// Validation For Name
			
			if(user.getFirstName().equals("")) {
				return new Result("FNE","Please Enter First Name",null);
			}
			
			if(!(user.getFirstName().length()<51 && user.getFirstName().length()>0)) {
				return new Result("FNL","User's First Name length should not be greater than 50 characters.",null);
			}
			
			if(!(user.getLastName().length()<50 && user.getFirstName().length()>0)) {
				return new Result("LNL","Please Enter First Name",null);
			}
			
			
			// Validation For Gender
			
			if(!user.getGender().matches("(?:[M|F|O])")) {
				return new Result("G","Please Enter Gender either M, F AND O in single character",null);
			}
			
			
			// Validation For Email
			
			if(user.getEmail().equals("")) {
				return new Result("EE","Please Enter Email",null);
			}
			
			if(!user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}")) {
				return new Result("ER","Please Enter Email in Correct Format",null);
			}
			
			if(userRepository.findByEmail(user.getEmail())!=null) {
				return new Result("EAP","Email is Already Present",null);
			}
			
			
			// Validation For Phone
			
			if(user.getPhone().equals("")) {
				return new Result("PE","Please Enter Phone Number",null);
			}
			
			if(!user.getPhone().matches("[+]+[0-9]{2}+[-]+[0-9]{10}")) {
				return new Result("PR","Please Enter Correct Format for Phone For E.g..+91-7974123456 ",null);
			}
			
			if(userRepository.findByPhone(user.getPhone())!=null) {
				return new Result("PAP","Phone Number is Already Present",null);
			}
			
			
			// Validation For Password
			
			if(user.getPassword().equals("")) {
				return new Result("PE","Please Enter  Password",null);
			}
			
			if(!user.getPassword().matches("^(?=.*[A-Z])[A-Za-z0-9].{8,16}")) {
				return new Result("E","Please Enter Correct Format for Password Like : A password must have at "
						+ "least 8 characters, consists of only letters and digits, must "
						+ "contain at least two digits & at least "
						+ "one uppercase character",null);
			}
			
			//////////////////-----VALIDATIONS ENDS HERE--------////////////////////
			
			if(Objects.nonNull(user.getFirstName()) && 
					!"".equalsIgnoreCase(user.getFirstName())) {
					user1.setFirstName(user.getFirstName());
			}
			if(Objects.nonNull(user.getLastName()) && 
					!"".equalsIgnoreCase(user.getLastName())) {
					user1.setLastName(user.getLastName());
			}
			if(Objects.nonNull(user.getGender()) && 
					!"".equalsIgnoreCase(user.getGender())) {
					user1.setGender(user.getGender());
			}
			if(Objects.nonNull(user.getEmail()) && 
					!"".equalsIgnoreCase(user.getEmail())) {
					user1.setEmail(user.getEmail());
			}
			if(Objects.nonNull(user.getPhone()) && 
					!"".equalsIgnoreCase(user.getPhone())) {
					user1.setPhone(user.getPhone());
			}
			if(Objects.nonNull(user.getPassword()) && 
					!"".equalsIgnoreCase(user.getPassword())) {
					user1.setPassword(user.getPassword());
			}
			if(Objects.nonNull(user.getDateOfBirth())) {
					user1.setDateOfBirth(user.getDateOfBirth());
			}
			if(Objects.nonNull(user.getProfilePhoto())) {
					user1.setProfilePhoto(user.getProfilePhoto());
			}
			
			userRepository.save(user1);
			return new Result("OK","User Updated Successfully",user1);
			
		}else {
			throw new UserException("User is not Present with the Given Id : "+userId);
		}
	}

	@Override
	public Result fetchUserByIdorEmailorPhone(String userId, String email, String phone) throws UserException {
		
		User user = userRepository.findByIdOrEmailOrPhone(userId, email, phone);
		
		if(user!=null) {
			return new Result("OK","User Successfully Fetched",user);
		}else {
			throw new UserException("No Data Found with given parameters");
		}
	}
	
	@Override
	public Result fetchAllUsers() throws UserException {
		
		List<User> users = userRepository.findAll();
		if(users.size()!=0) {
			return new Result("OK","Users fetched Successfully!",users);
		}else {
			throw new UserException("No Data For Users Exist");
		}
	}

	@Override
	public Result fetchAllUsersBetweenDates(LocalDate startDate, LocalDate EndDate) throws UserException {
		
		List<User> users = userRepository.findByCreateDateBetween(startDate, EndDate);
		
		if(users.size()!=0) {
			return new Result("OK","All users fetched in the given dates",users);
		}else {
			throw new UserException("No Data For Users Exist");
		}
	}

	@Override
	public Result deleteUserById(String userId) throws UserException {
		
		Optional<User> opt =  userRepository.findById(userId);
		
		if(opt.isPresent()) {
			userRepository.deleteById(userId);
			return new Result("OK","Users Deleted Successfully!",opt.get());
		}else {
			throw new UserException("User is not present with given Id : "+userId);
		}
		
	}
	
}
