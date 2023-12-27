package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Complaint;
import com.cg.entity.Engineer;
import com.cg.entity.Product;
import com.cg.entity.repository.ComplaintRepo;
import com.cg.entity.repository.EngineerRepo;
import com.cg.exceptions.ResourceNotFoundException;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintRepo complaintRepo;

	@Autowired
	private EngineerRepo engineerRepo;

	@Override
	public Boolean bookComplaint(Complaint complaint) throws ResourceNotFoundException {
		Complaint c = complaintRepo.findById(complaint.getComplaintId()).get();
		if (c != null) {
			throw new ResourceNotFoundException("Complaint already registerd with id : " + complaint.getComplaintId());
		}
		complaintRepo.save(complaint);
		return true;
	}

	@Override
	public String changeComplaintStatus(Complaint complaint) throws ResourceNotFoundException {
		Complaint c = complaintRepo.findById(complaint.getComplaintId()).orElseThrow(
				() -> new ResourceNotFoundException("Complaint Doesn't exists with it :" + complaint.getComplaintId()));
		complaintRepo.delete(c);

		complaintRepo.save(complaint);
		return "Complaint status changed successfully";
	}

	@Override
	public List<Complaint> getClientALlComplaints(int client) {
		List<Complaint> listOfComplaints = complaintRepo.findAll();
		List<Complaint> newList = new ArrayList<Complaint>();
		try {
			for (int i = 0; i < listOfComplaints.size(); i++) {
				if (listOfComplaints.get(i).getClient().getClientId() == client) {
					newList.add(listOfComplaints.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newList;
	}

	@Override
	public Engineer getEngineer(int eId) throws ResourceNotFoundException {

		return engineerRepo.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Engineer Not found"));

	}

	@Override
	public List<Product> getProductByComplaint(int cid) throws ResourceNotFoundException {
		Complaint c = complaintRepo.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint is not found"));

		return c.getClient().getProduct();
	}

}
