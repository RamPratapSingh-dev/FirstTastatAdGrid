package com.learning.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class paymentResponseDto {
    String status;
    String debitedAmount;
    String PaymentMode;
}
