package com.hexagonal.addresses.infrastructure.repositories;

import com.hexagonal.addresses.infrastructure.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJpaAddressRepository extends JpaRepository<AddressEntity, Long> {
}
