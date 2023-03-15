package com.zkteco.entity;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.type.TrueFalseConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user_table")
public class User {

	@Id
	@Column(name = "user_Id")
	private String userId;
		
	@Column(name = "first_Name")
	private String firstName;
		
	@Column(name = "Last_Name")
	private String lastName;
		
	@Column(name = "Gender")
	private String gender;
		
	@Column(name = "Email")
	private String email;
		
	@Column(name = "Phone")
	private String phone;
		
	@Column(name = "Password")
	private String password;
		
	@Column(name = "Date_of_Birth")
	private Date dateOfBirth;
		
	@Column(name = "Profile_Photo")
	private Boolean profilePhoto;
		
	@Column(name = "Create_Date")
	private LocalDate createDate;
		
	@Column(name = "Update_Date")
	private LocalDate updateDate;
	
}
