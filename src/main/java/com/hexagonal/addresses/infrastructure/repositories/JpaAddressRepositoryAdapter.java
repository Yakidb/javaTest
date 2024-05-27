package com.hexagonal.addresses.infrastructure.repositories;

import com.hexagonal.addresses.domain.models.AddressModel;
import com.hexagonal.addresses.domain.ports.out.IAddressRepositoryPort;
import com.hexagonal.addresses.infrastructure.entities.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaAddressRepositoryAdapter implements IAddressRepositoryPort {

    private final IJpaAddressRepository jpaAddressRepository;

    public JpaAddressRepositoryAdapter(
            IJpaAddressRepository jpaAddressRepository) {
        this.jpaAddressRepository = jpaAddressRepository;
    }

    @Override
    public AddressModel save(AddressModel addressModel) {
        AddressEntity addressEntity = AddressEntity.fromDomainModel(addressModel);
        AddressEntity savedEntity = jpaAddressRepository.save(addressEntity);
        return savedEntity.toDomainModel();
    }

    @Override
    public List<AddressModel> findAll() {
        return jpaAddressRepository.findAll().stream()
                .map(AddressEntity::toDomainModel)
                .collect(Collectors.toList());
    }
}
