package com.hexagonal.addresses.infrastructure.controllers;

import com.hexagonal.addresses.application.services.AddressService;
import com.hexagonal.addresses.domain.models.AddressModel;
import com.hexagonal.addresses.infrastructure.DTO.AddressDto;
import com.hexagonal.addresses.infrastructure.mapper.AddressMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto){
        AddressModel addressModelToSend = AddressMapper.convertToModel(addressDto);
        AddressModel createdAddressModel = addressService.createAddress(addressModelToSend);
        return new ResponseEntity<>(AddressMapper.convertToDto(createdAddressModel), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AddressDto>> listAddresses(){
        List<AddressModel> addressModels = addressService.getAllAddresses();
        List<AddressDto> addressDtos = addressModels.stream()
                .map(AddressMapper::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(addressDtos, HttpStatus.OK);
    }
}
