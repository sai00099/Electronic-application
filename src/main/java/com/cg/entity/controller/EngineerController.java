package com.cg.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Complaint;
import com.cg.entity.Engineer;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.service.EngineerService;

@RestController
@RequestMapping("/engineer")
public class EngineerController {

	@Autowired
	private EngineerService engineerService;

	@GetMapping("/getAllOpenComplaintsForPerticularEngineer")
	public List<Complaint> getAllOpenComplaints(@RequestParam int engineerId) {
		return engineerService.getAllOpenComplaints(engineerId);
	}

	@GetMapping("/getResolvedComplaints")
	public List<Complaint> getResolvedComplaints(@RequestParam int e) {
		return engineerService.getResolvedComplaints(e);

	}

	@PutMapping("/changeComplaintStatus")
	public String changeComplaintStatus(@RequestParam int complaintId, @RequestBody Complaint cid)
			throws ResourceNotFoundException {
		return engineerService.changeComplaintStatus(complaintId, cid);
	}

}
