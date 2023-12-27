package com.cg.service;

import java.util.List;

import com.cg.entity.Client;
import com.cg.entity.Complaint;
import com.cg.entity.Engineer;
import com.cg.entity.Product;
import com.cg.exceptions.ResourceNotFoundException;

public interface ComplaintService {

	Boolean bookComplaint(Complaint complaint) throws ResourceNotFoundException;

	String changeComplaintStatus(Complaint complaint) throws ResourceNotFoundException;

	List<Complaint> getClientALlComplaints(int client);

	Engineer getEngineer(int eId) throws ResourceNotFoundException;

	List<Product > getProductByComplaint(int cid) throws ResourceNotFoundException;
}
