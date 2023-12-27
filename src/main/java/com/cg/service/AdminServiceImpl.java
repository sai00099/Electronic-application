package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Client;
import com.cg.entity.Complaint;
import com.cg.entity.Engineer;
import com.cg.entity.Product;
import com.cg.entity.repository.AdminRepo;
import com.cg.entity.repository.ClientRepo;
import com.cg.entity.repository.ComplaintRepo;
import com.cg.entity.repository.EngineerRepo;
import com.cg.entity.repository.ProductRepo;
import com.cg.exceptions.ResourceNotFoundException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private ClientRepo clientRepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private EngineerRepo engineerRepo;

	@Autowired
	private ComplaintRepo complaintRepo;

	@Override
	public void addEngineer(Engineer engineer) throws Exception {
		Optional<Engineer> e = engineerRepo.findById(engineer.getEngineerId());
		if (e.isPresent()) {
			throw new Exception("Engineer Already Exists with id " + engineer.getEngineerId());
		}
		engineerRepo.save(engineer);
	}

	@Override
	public void changeDomain(int engineerId, String domain) throws Exception {

		Engineer e = engineerRepo.findById(engineerId)
				.orElseThrow(() -> new Exception("Engineer not found with id : " + engineerId));
		e.setDomain(domain);
		engineerRepo.save(e);
	}

	@Override
	public void removeEngineer(int engineerId) throws Exception {
		Engineer e = engineerRepo.findById(engineerId)
				.orElseThrow(() -> new Exception("Engineer not found with id : " + engineerId));
		engineerRepo.delete(e);

	}

	@Override
	public List<Complaint> getComplaintsByProducts(String productName) {

		List<Complaint> list = complaintRepo.findAll();
		List<Complaint> list2 = new ArrayList<>();
		try {
			for (int i = 0; i < list.size(); i++) {
				List<Product> listp = list.get(i).getClient().getProduct();
				for (int j = 0; i < listp.size(); j++) {
					if (listp.get(j).getProductName().equals(productName)) {
						list2.add(list.get(i));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list2;
	}

	@Override
	public List<Complaint> getComplaints() {
		return complaintRepo.findAll();
	}

	@Override
	public Complaint replaceEngineerFromComplaint(int complaintId, int e) throws ResourceNotFoundException {
		Complaint c = complaintRepo.findById(complaintId)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint not found : " + complaintId));
		c.setEngineerId(e);
		return complaintRepo.save(c);
	}

}
