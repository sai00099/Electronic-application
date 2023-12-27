package com.cg.entity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Admin;
import com.cg.entity.Engineer;
import com.cg.entity.repository.AdminRepo;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminRepo adminRepo;

	@PostMapping("/addAdmin")
	public ResponseEntity<?> addAdmin(@RequestBody @Valid Admin admin) {
		return ResponseEntity.ok(adminRepo.save(admin));
	}

	@PostMapping("/add-engineer")
	public ResponseEntity<?> addEngineer(@RequestBody Engineer engineer) throws Exception {
		adminService.addEngineer(engineer);
		return new ResponseEntity<>("Engineer added in server ", HttpStatus.CREATED);
	}

	@PutMapping("/change-domain")
	public ResponseEntity<?> changeDomain(@RequestParam int engineerId, @RequestParam String domain) throws Exception {
		adminService.changeDomain(engineerId, domain);
		return new ResponseEntity<>("Domain Changed ", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove-engineer")
	public ResponseEntity<?> removeEngineer(@RequestParam int engineerId) throws Exception {
		adminService.removeEngineer(engineerId);
		return new ResponseEntity<>("Engineer Removed by admin Successfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/get-complaints-by-products")
	public ResponseEntity<?> getComplaintsByProducts(@RequestParam String productName) {
		return new ResponseEntity<>(adminService.getComplaintsByProducts(productName), HttpStatus.ACCEPTED);
	}

	@GetMapping("/get-complaints")
	public ResponseEntity<?> getComplaints() {
		return ResponseEntity.ok(adminService.getComplaints());
	}

	@PutMapping("/replace-engineer-from-complaint")
	public ResponseEntity<?> replaceEngineerFromComplaint(@RequestParam int complaintId, @RequestParam int engineerId)
			throws ResourceNotFoundException {
		adminService.replaceEngineerFromComplaint(complaintId, engineerId);
		return new ResponseEntity<>("Engineer replaced successfully", HttpStatus.ACCEPTED);
	}
}
