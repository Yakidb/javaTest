package com.hexagonal.addresses.infrastructure.mapper;

import com.hexagonal.addresses.domain.models.AddressModel;
import com.hexagonal.addresses.infrastructure.DTO.AddressDto;

public class AddressMapper {

    public static AddressDto convertToDto(AddressModel addressModel) {
        return new AddressDto(addressModel.getId(),addressModel.getTitle(), addressModel.getDescription());
    }

    public static AddressModel convertToModel(AddressDto addressDto) {
        return new AddressModel(addressDto.getTitle(), addressDto.getDescription(), addressDto.getId());
    }
}
