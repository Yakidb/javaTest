package com.hexagonal.addresses.infrastructure.controllers;

import com.hexagonal.addresses.application.services.AddressService;
import com.hexagonal.addresses.domain.models.AddressModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AddressController.class)
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    AddressModel addressModelObjectTest1;
    AddressModel addressModelObjectTest2;

    @BeforeEach
    void setUp() {
        addressModelObjectTest1 = new AddressModel("Title1", "Description1", 1);
        addressModelObjectTest2 = new AddressModel("Title2", "Description2", 2);
    }

    // TEST1 CREATE ADDRESS
    @Test
    public void saveAddressTest1() throws Exception {
        AddressModel postAddressModel = new AddressModel();
        postAddressModel.setDescription("Description1");
        postAddressModel.setTitle("Title1");

        Mockito.when(addressService.createAddress(Mockito.any(AddressModel.class))).thenReturn(addressModelObjectTest1);

        mockMvc.perform(post("/api/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "        \"title\": \"Title1\",\n" +
                                "        \"description\": \"Description1\"\n" +
                                "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is("Title1")))
                .andExpect(jsonPath("$.description", is("Description1")))
                .andExpect(jsonPath("$.id", is(1)));
    }

    // TEST2 GET ADDRESS
    @Test
    public void listAddresses() throws Exception {
        ArrayList<AddressModel> listAddressModels = new ArrayList<>(Arrays.asList(addressModelObjectTest1, addressModelObjectTest2));

        Mockito.when(addressService.getAllAddresses()).thenReturn(listAddressModels);

        mockMvc.perform(get("/api/address/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Title1")))
                .andExpect(jsonPath("$[0].description", is("Description1")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].title", is("Title2")))
                .andExpect(jsonPath("$[1].description", is("Description2")))
                .andExpect(jsonPath("$[1].id", is(2)));
    }
}
