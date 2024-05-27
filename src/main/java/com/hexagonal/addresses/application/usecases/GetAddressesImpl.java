package com.hexagonal.addresses.application.usecases;

import com.hexagonal.addresses.domain.models.AddressModel;
import com.hexagonal.addresses.domain.ports.in.IGetAddressesUseCase;
import com.hexagonal.addresses.domain.ports.out.IAddressRepositoryPort;

import java.util.List;

public class GetAddressesImpl implements IGetAddressesUseCase {
    private final IAddressRepositoryPort addressRepositoryPort;


    public GetAddressesImpl(
            IAddressRepositoryPort addressRepositoryPort
    ) {
        this.addressRepositoryPort = addressRepositoryPort;
    }

    @Override
    public List<AddressModel> getAllAddresses() {
        return addressRepositoryPort.findAll();
    }
}
