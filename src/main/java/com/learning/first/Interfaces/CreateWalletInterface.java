package com.learning.first.Interfaces;


import com.learning.first.dto.CreateWalletDto;
import com.learning.first.dto.CreateWalletResponseDto;

public interface CreateWalletInterface {

    public CreateWalletResponseDto CreateWallet(CreateWalletDto request);
}
