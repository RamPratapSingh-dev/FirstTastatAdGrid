package com.learning.first.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWalletDto {

        @NotBlank(message ="Name cannot be empty")
        String name;

    @NotBlank(message = "Gender cannot be empty")
    String gender;

    @NotBlank(message = "Adress cannot be empty")
    String address;

    @NotBlank(message = "phone no cannot be empty")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must be exactly 10 digits and contain only numbers"
    )
    String phoneNo;

}
