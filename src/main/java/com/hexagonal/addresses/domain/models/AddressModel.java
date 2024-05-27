package com.hexagonal.addresses.domain.models;

public class AddressModel {
    private long id;
    private String title;
    private String description;

    //                                                      //Constructor with arguments
    public AddressModel(String title, String description, long id) {
        this.title = title;
        this.description = description;
        this.id = id;
    }

    //                                                      //Constructor without arguments
    public AddressModel() {
    }


    //                                                      //Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
