package com.learning.first.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;



@Data
public class paymentRequestDto {
    @NotBlank(message = "payment Type should be Defined")
    String paymentType;

    @NotNull(message = " Amount should not be null")
    @Positive(message = "Amount should be greater than 0 ")
    Double amount;
    @NotBlank(message = "Token must not be null for validation")
    String token;

    @NotBlank(message = "Account number must not be blank")
    String accountNo;
}
