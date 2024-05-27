package com.hexagonal.addresses.application.services;
import com.hexagonal.addresses.domain.models.AddressModel;
import com.hexagonal.addresses.domain.ports.in.ICreateAddressUseCase;
import com.hexagonal.addresses.domain.ports.in.IGetAddressesUseCase;

import java.util.List;

public class AddressService implements ICreateAddressUseCase, IGetAddressesUseCase {

    private final ICreateAddressUseCase createAddressUseCase;
    private final IGetAddressesUseCase getAddressesUseCase;

    public AddressService(ICreateAddressUseCase createAddressUseCase,
                          IGetAddressesUseCase getAddressesUseCase
    ) {
        this.createAddressUseCase = createAddressUseCase;
        this.getAddressesUseCase = getAddressesUseCase;
    }

    @Override
    public AddressModel createAddress(AddressModel addressModel) {
        return createAddressUseCase.createAddress(addressModel);
    }

    @Override
    public List<AddressModel> getAllAddresses() {
        return getAddressesUseCase.getAllAddresses();
    }
}
