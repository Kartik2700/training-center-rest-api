package com.kartik.traini8.Model;

import jakarta.validation.constraints.*;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Address Class to store the address of Training Centers
 */

@Embeddable//This class is embedded in another entity TrainingCenter
@Data //To generate getter-setter
@NoArgsConstructor//To generate No argument constructor
@AllArgsConstructor//To generate constructor with parameter of all field
public class Address {

    @NotBlank(message = "Detailed address is mandatory")
    private String detailedAddress;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Pincode must be a 6 digit number")
    private String pincode;
}
