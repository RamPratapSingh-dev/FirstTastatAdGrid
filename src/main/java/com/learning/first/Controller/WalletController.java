package com.learning.first.Controller;

import com.learning.first.Interfaces.CreateWalletInterface;
import com.learning.first.dto.ApiResponse;
import com.learning.first.dto.CreateWalletDto;
import com.learning.first.dto.CreateWalletResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    private final CreateWalletInterface createWallet;

    public WalletController(CreateWalletInterface createWallet) {

        this.createWallet = createWallet;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CreateWalletResponseDto>> CreateWallet(@Valid @RequestBody CreateWalletDto request)
    {

        return ResponseEntity.ok(ApiResponse.success("Wallet created successfully", createWallet.CreateWallet(request)));
    }





}
