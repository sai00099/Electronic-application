package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {

	@Id
	private int complaintId;

	@NotEmpty(message = "Product Model Number shouldn't be null or empty")
	@Size(min = 4,max=14,message = "product length should be min 4 and max 14 chars")
	private String productModelNumber;

	
	private String complaintName;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "client_fk", referencedColumnName = "clientId")
	private Client client;
//
//	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "engineerid_fk",referencedColumnName = "engineerId")
//	private Engineer engineer;

//	private int clientId;

	@NotNull(message = "engineer Id shouldn't be null")
	private int engineerId;

	@Enumerated(EnumType.STRING)
	private Status status;

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getProductModelNumber() {
		return productModelNumber;
	}

	public void setProductModelNumber(String productModelNumber) {
		this.productModelNumber = productModelNumber;
	}

	public String getComplaintName() {
		return complaintName;
	}

	public void setComplaintName(String complaintName) {
		this.complaintName = complaintName;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Complaint(int complaintId,
			@NotEmpty(message = "Product Model Number shouldn't be null or empty") @Size(min = 4, max = 14, message = "product length should be min 4 and max 14 chars") String productModelNumber,
			String complaintName, Client client, @NotNull(message = "engineer Id shouldn't be null") int engineerId,
			Status status) {
		super();
		this.complaintId = complaintId;
		this.productModelNumber = productModelNumber;
		this.complaintName = complaintName;
		this.client = client;
		this.engineerId = engineerId;
		this.status = status;
	}

	public Complaint() {
		super();
	}

}
