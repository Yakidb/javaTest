package com.hexagonal.addresses.domain.ports.in;

import com.hexagonal.addresses.domain.models.AddressModel;

import java.util.List;

public interface IGetAddressesUseCase {
    List<AddressModel> getAllAddresses();
}
