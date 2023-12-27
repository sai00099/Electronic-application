package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	@Id
	private int adminId;

	@NotEmpty(message = "password shouldn't be Null or Empty...!!")
	@Size(min = 4, max = 25, message = "Password should me min 4 and max 25 chars")
	private String password;

	@NotNull(message = "contact number shouldn't be null or blank")
	@Column(unique = true,nullable = false)
	@Size(min = 10, max = 10, message = "contact number should be min 10 and max 10 numbers")
	//@Length(min = 10,max = 10)
	private String contactNumner;
	
	@Email
	@Size(min = 8, max = 30, message = "Eamil length should be min 8 and max 30 chars")
	private String email;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumner() {
		return contactNumner;
	}

	public void setContactNumner(String contactNumner) {
		this.contactNumner = contactNumner;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Admin(int adminId,
			@NotEmpty(message = "password shouldn't be Null or Empty...!!") @Size(min = 4, max = 25, message = "Password should me min 4 and max 25 chars") String password,
			@NotNull(message = "contact number shouldn't be null or blank") @Size(min = 10, max = 10, message = "contact number should be min 10 and max 10 numbers") String contactNumner,
			@Email @Size(min = 8, max = 30, message = "Eamil length should be min 8 and max 30 chars") String email) {
		super();
		this.adminId = adminId;
		this.password = password;
		this.contactNumner = contactNumner;
		this.email = email;
	}

	public Admin() {
		super();
	}
	

}
