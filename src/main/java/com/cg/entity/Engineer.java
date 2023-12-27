package com.cg.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engineer {

	@Id
	private int engineerId;

	@Size(min = 4, max = 25, message = "password should be min 4 and max 25 chars")
	private String password;

	@NotEmpty(message = "engineer name shouldn't be null or empty ...!!")
	private String engineerName;

	private String domain;

	@OneToMany
	@JoinColumn(name = "complaint_fk")
	private List<Complaint> complaints;

	public int getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Engineer(int engineerId,
			@Size(min = 4, max = 25, message = "password should be min 4 and max 25 chars") String password,
			@NotEmpty(message = "engineer name shouldn't be null or empty ...!!") String engineerName, String domain,
			List<Complaint> complaints) {
		super();
		this.engineerId = engineerId;
		this.password = password;
		this.engineerName = engineerName;
		this.domain = domain;
		this.complaints = complaints;
	}

	public Engineer() {
		super();
	}

}
