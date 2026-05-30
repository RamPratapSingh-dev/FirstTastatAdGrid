package com.learning.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateWalletResponseDto {
    String Account_number;
    String Name;
    String Gender;
    String Adress;
    String Phone_Number;
    Double Amount;
    String Status;
}
