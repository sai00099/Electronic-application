package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.entity.Complaint;
import com.cg.entity.Engineer;
import com.cg.exceptions.ResourceNotFoundException;

public interface EngineerService {

	List<Complaint> getAllOpenComplaints(int e);

	List<Complaint> getResolvedComplaints(int e);

	List<Complaint> getResolvedComplaintsByDate(int e, LocalDate date);

	String changeComplaintStatus(int complaintId, Complaint cid) throws ResourceNotFoundException;

}
