package com.hexagonal.addresses.domain.ports.in;

import com.hexagonal.addresses.domain.models.AddressModel;

public interface ICreateAddressUseCase {
    AddressModel createAddress(AddressModel addressModel);
}
