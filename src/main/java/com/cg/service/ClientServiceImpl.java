package com.cg.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Client;
import com.cg.entity.Complaint;
import com.cg.entity.Engineer;
import com.cg.entity.Product;
import com.cg.entity.repository.ClientRepo;
import com.cg.entity.repository.ComplaintRepo;
import com.cg.entity.repository.EngineerRepo;
import com.cg.exceptions.ResourceNotFoundException;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepo clientRepo;

	@Autowired
	private EngineerRepo engineerRepo;

	@Autowired
	private ComplaintRepo complaintRepo;

	@Override
	public void saveClient(Client client) throws ResourceNotFoundException {
//		List<Complaint> list = client.getComplaints();
//		try {
//			for (int i = 0; i < list.size(); i++) {
//				try {
//					System.out.println(list.get(i).getEngineerId());
//					System.out.println(engineerRepo.findById(list.get(i).getEngineerId()));
//				if (list.get(i).getEngineerId() == engineerRepo.findById(list.get(i).getEngineerId()).get()
//						.getEngineerId()) {
//					
//				}
//				}
//				catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		} catch (Exception e) {
//			throw new ResourceNotFoundException("Requested Engineer Deosn't exist");
//		}
		clientRepo.save(client);

	}

	@Override
	public Client getClientByClientId(int id) throws ResourceNotFoundException {

		return clientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not Found with id :" + id));
	}

	@Override
	public Engineer getEngineerById(int eid) throws ResourceNotFoundException {
		Engineer e = engineerRepo.findById(eid)
				.orElseThrow(() -> new ResourceNotFoundException("Engineer Not found with id : " + eid));

		return e;
	}

	@Override
	public List<Engineer> getListOFEngineersByDomain(String domain) {

		return engineerRepo.findAll().stream().filter(a -> a.getDomain().equals(domain)).collect(Collectors.toList());
	}

	@Override
	public String changeStatusOfComplaint(int cid, Complaint complaint) throws ResourceNotFoundException {
		Complaint c = complaintRepo.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint not present with id " + cid));
		c.setStatus(complaint.getStatus());
		complaintRepo.save(c);
		return "Complaint Status changed";
	}

	@Override
	public Client signIn(Long phoneNumber, String password) throws Exception {

		return clientRepo.signIn(phoneNumber, password).orElseThrow(() -> new Exception("Invalid Credentials"));
	}

	@Override
	public String signOut(Long phoneNumber, String password) throws Exception {
		Client c = clientRepo.signIn(phoneNumber, password).orElseThrow(() -> new Exception("Invalid Credentials"));
		if (c == null) {
			throw new Exception("Sign out has not done");
		}
		return "Sign out done ";
	}

}
