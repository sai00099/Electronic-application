package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Complaint;
import com.cg.entity.Status;
import com.cg.entity.repository.ComplaintRepo;
import com.cg.entity.repository.EngineerRepo;
import com.cg.exceptions.ResourceNotFoundException;

@Service
public class EngineerServiceImpl implements EngineerService {

	@Autowired
	private EngineerRepo engineerRepo;
	@Autowired
	private ComplaintRepo complaintRepo;

	@Override
	public List<Complaint> getAllOpenComplaints(int e) {
		return complaintRepo.findAll().stream().filter(ee -> ee.getEngineerId() == e).collect(Collectors.toList());
	}

	@Override
	public List<Complaint> getResolvedComplaints(int e) {
		return complaintRepo.findAll().stream().filter(a -> a.getStatus().equals(Status.RESOLVED) && e == a.getEngineerId())
				.collect(Collectors.toList());
	}

	@Override
	public List<Complaint> getResolvedComplaintsByDate(int e, LocalDate date) {

		// complaintRepo.findAll().stream().filter(a->
		// a.getEngineer().getEngineerId()==e.getEngineerId() && date.equals(a.get)));
		return null;
	}

	@Override
	public String changeComplaintStatus(int complaintId, Complaint cid) throws ResourceNotFoundException {
		Complaint c = complaintRepo.findById(complaintId)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint not found "));
		c.setStatus(cid.getStatus());
		complaintRepo.save(c);
		return "Status changed ";
	}

}
