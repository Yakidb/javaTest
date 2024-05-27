package com.hexagonal.addresses.infrastructure.config;

import com.hexagonal.addresses.application.services.AddressService;
import com.hexagonal.addresses.application.usecases.CreateAddressImpl;
import com.hexagonal.addresses.application.usecases.GetAddressesImpl;
import com.hexagonal.addresses.domain.ports.out.IAddressRepositoryPort;
import com.hexagonal.addresses.infrastructure.repositories.JpaAddressRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public AddressService addressService(IAddressRepositoryPort addressRepositoryPort){
        return new AddressService(
                new CreateAddressImpl(addressRepositoryPort),
                new GetAddressesImpl(addressRepositoryPort)
        );
    };

    @Bean
    public IAddressRepositoryPort addressRepositoryPort(JpaAddressRepositoryAdapter jpaAddressRepositoryAdapter){
        return jpaAddressRepositoryAdapter;
    };
}
