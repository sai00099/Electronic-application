package com.cg.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Complaint;
import com.cg.entity.Status;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Integer> {

	@Query(value = "select o from Complaint o where o.client.product.productName=?1", nativeQuery = true)
	public List<Complaint> getComplaintsByProducts(String productName);
	
//	@Query(value = "select o from Complaint o where o.status=?1 and o.engineerId=?2")
//	public List<Complaint> getResolvedComplaints( ,int engineeId);

}
