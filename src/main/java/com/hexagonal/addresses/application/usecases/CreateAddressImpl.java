package com.hexagonal.addresses.application.usecases;

import com.hexagonal.addresses.domain.models.AddressModel;
import com.hexagonal.addresses.domain.ports.in.ICreateAddressUseCase;
import com.hexagonal.addresses.domain.ports.out.IAddressRepositoryPort;

public class CreateAddressImpl implements ICreateAddressUseCase {
    private final IAddressRepositoryPort addressRepositoryPort;

    public CreateAddressImpl(
            IAddressRepositoryPort addressRepositoryPort
    ) {
        this.addressRepositoryPort = addressRepositoryPort;
    }

    @Override
    public AddressModel createAddress(AddressModel addressModel) {
        return addressRepositoryPort.save(addressModel);
    }
}
