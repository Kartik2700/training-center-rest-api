package com.kartik.traini8.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

/*
    TrainingCenter class  represents a training center Details in application
    Mapped to a database table by JPA
 */
@Data
@Entity // Marks this class as a JPA entity, which will be mapped to a database table(Object Relational Mapping)
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenter {

    @Id//TO make filed primary key
    @NotBlank(message = "Center code is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")// Validation for centerCode format
    private String centerCode; //Unique Code for training center ,must be 12 alphanumeric characters

    @NotBlank(message = "Center name is mandatory")
    @Size(max = 40, message = "Center name should be less than 40 characters")
    private String centerName; //Name of training center maximum length 40.

    @Embedded // Indicates that the Address class is embedded in this entity
    private Address address; //Address class object , store the address of training center

    @Min(value = 0, message = "Student capacity must be positive") // Validating to ensure Number of student remains non-negative
    private int studentCapacity;

    @ElementCollection //Collection of simple types(String,Integer etc)
    private List<String> coursesOffered;

    private long createdOn; // Timestamp for when the training center was created (in epoch seconds)

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String contactEmail;

    @NotBlank(message = "Contact phone is mandatory")
    @Pattern(regexp = "^[1-9][0-9]{9}$", message = "Phone number must be 10 digits")// Validation for phone number format to prevent leading zeroes
    private String contactPhone;

    @PrePersist// This method will be called before the entity is saved to the database
    public void onCreate() {
        this.createdOn = Instant.now().getEpochSecond(); // Store the creation time as an epoch second
    }

}
