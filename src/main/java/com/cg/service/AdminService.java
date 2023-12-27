package com.cg.service;

import java.util.List;

import com.cg.entity.Complaint;
import com.cg.entity.Engineer;
import com.cg.exceptions.ResourceNotFoundException;

public interface AdminService {

	void addEngineer(Engineer engineer) throws Exception;

	void changeDomain(int engineerId, String domain) throws Exception;

	void removeEngineer(int engineerId) throws Exception;

	List<Complaint> getComplaintsByProducts(String productName);

	List<Complaint> getComplaints();

	Complaint replaceEngineerFromComplaint(int id, int e) throws ResourceNotFoundException;
	
}
