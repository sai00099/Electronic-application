package com.cg.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

	@Query(value = "select o from Client o where o.phoneNumber=?1 and o.password=?2")
	Optional<Client> signIn(Long phoneNumber, String password);

}
