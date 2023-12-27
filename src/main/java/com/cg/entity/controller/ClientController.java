package com.cg.entity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Client;
import com.cg.entity.Complaint;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

//	void saveClient(Client client);
//
//	Client getClientByClientId(int id) throws ResourceNotFoundException;
//
//	Engineer getEngineerById(int eid) throws ResourceNotFoundException;
//
//	List<Engineer> getListOFEngineersByDomain(String domain);
//
//	String changeStatusOfComplaint(int cid, Complaint complaint) throws ResourceNotFoundException;
//
//	Client signIn(Long phoneNumber, String password) throws Exception;
//
//	String signOut(Long phoneNumber, String password) throws Exception;

	@PostMapping("/signOut")
	public ResponseEntity<?> signOut(Long phoneNumber, String password) throws Exception {
		return ResponseEntity.ok(clientService.signOut(phoneNumber, password));
	}

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(Long phoneNumber, String password) throws Exception {
		return ResponseEntity.ok(clientService.signIn(phoneNumber, password));
	}

//	@PutMapping("/change-status-of-complaint")
//	public ResponseEntity<?> changeStatusOfComplaint(@RequestParam int cid, @RequestBody Complaint complaint)
//			throws ResourceNotFoundException {
//
//		return ResponseEntity.ok(clientService.changeStatusOfComplaint(cid, complaint));
//	}

	@GetMapping("/get-list-of-engineers-by-domain")
	public ResponseEntity<?> getListOfEngineersByDomain(@RequestParam String domain) {
		return ResponseEntity.ok(clientService.getListOFEngineersByDomain(domain));
	}

	@PostMapping("/save-client")
	public ResponseEntity<?> saveClient(@RequestBody @Valid Client client) throws ResourceNotFoundException {
		clientService.saveClient(client);
		return new ResponseEntity<>("Client data Saved successfully", HttpStatus.CREATED);
	}

	@GetMapping("/get-client-by-client-id")
	public ResponseEntity<?> getClientByClientId(@RequestParam int clientId) throws ResourceNotFoundException {
		return ResponseEntity.ok(clientService.getClientByClientId(clientId));
	}

	@GetMapping("get-engineer-by-id")
	public ResponseEntity<?> getEngineerById(@RequestParam int engineerId) throws ResourceNotFoundException {
		return ResponseEntity.ok(clientService.getEngineerById(engineerId));
	}

}
