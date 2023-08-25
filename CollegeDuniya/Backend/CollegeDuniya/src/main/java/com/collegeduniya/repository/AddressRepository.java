package com.collegeduniya.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegeduniya.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Optional<Address> findByPincode(String addressPincode);

}
