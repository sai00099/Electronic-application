package com.cg.entity.controller;

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
import com.cg.service.ComplaintService;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@GetMapping("/get-product-by-complaint")
	public ResponseEntity<?> getProductByComplaint(int cid) throws ResourceNotFoundException {
		return ResponseEntity.ok(complaintService.getProductByComplaint(cid));
	}

	@GetMapping("/get-Engineer")
	public ResponseEntity<?> getEngineer(@RequestParam int engineerId) throws ResourceNotFoundException {
		return ResponseEntity.ok(complaintService.getEngineer(engineerId));

	}

	@GetMapping("get-client-all-complaint")
	public ResponseEntity<?> getClientAllComplaint(@RequestParam int clientId) {
		return ResponseEntity.ok(complaintService.getClientALlComplaints(clientId));
	}

	@PostMapping("/register-complaint")
	public ResponseEntity<?> bookComplaint(@RequestBody Complaint complaint) throws ResourceNotFoundException {
		Boolean b = complaintService.bookComplaint(complaint);
		if (b) {
			return new ResponseEntity<>("Complaint registed successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Complaint not registed try again", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/change-complaint")
	public ResponseEntity<?> changeComplaintStatus(@RequestBody Complaint complaint) throws Exception {
		complaintService.changeComplaintStatus(complaint);
		return new ResponseEntity<>("Status Changed ", HttpStatus.ACCEPTED);
	}

}
