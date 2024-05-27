package com.hexagonal.addresses.infrastructure.entities;

import com.hexagonal.addresses.domain.models.AddressModel;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private String description;

    public AddressEntity(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public AddressEntity() {
    }

    public static AddressEntity fromDomainModel(
            AddressModel addressModel
    ){
        return new AddressEntity(addressModel.getId(), addressModel.getTitle(), addressModel.getDescription());
    }

    public AddressModel toDomainModel(){
        return new AddressModel(title, description, id);
    }
}
