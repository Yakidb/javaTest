package com.hexagonal.addresses.domain.ports.out;

import com.hexagonal.addresses.domain.models.AddressModel;

import java.util.List;

public interface IAddressRepositoryPort {
    AddressModel save(AddressModel addressModel);
    List<AddressModel> findAll();
}
