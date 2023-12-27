package com.cg.service;

import java.util.List;

import com.cg.entity.Client;
import com.cg.entity.Complaint;
import com.cg.entity.Engineer;
import com.cg.exceptions.ResourceNotFoundException;

public interface ClientService {

	void saveClient(Client client) throws ResourceNotFoundException;

	Client getClientByClientId(int id) throws ResourceNotFoundException;

	Engineer getEngineerById(int eid) throws ResourceNotFoundException;

	List<Engineer> getListOFEngineersByDomain(String domain);

	String changeStatusOfComplaint(int cid, Complaint complaint) throws ResourceNotFoundException;

	Client signIn(Long phoneNumber, String password) throws Exception;

	String signOut(Long phoneNumber, String password) throws Exception;

}
