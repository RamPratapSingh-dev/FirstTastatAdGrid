package com.learning.first.Service;

import com.learning.first.Interfaces.PaymentInterface;
import com.learning.first.dto.paymentRequestDto;
import com.learning.first.exception.AccountNotFoundException;
import com.learning.first.exception.InsufficientBalanceException;
import com.learning.first.exception.InvalidAuthenticationToken;
import com.learning.first.modal.CreateWalletModal;
import com.learning.first.modal.PaymentTrack;
import com.learning.first.repository.CreateWalletRepository;
import com.learning.first.repository.PaymentTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service("PayPal")
@Transactional(rollbackFor = Exception.class)
public class PayPal implements PaymentInterface {

    @Autowired
    private PaymentTrackRepository paymentRepo;

    @Autowired
    private CreateWalletRepository walletRepo;

    @Override
    public boolean validateDetails(paymentRequestDto request) {
        if (request.getToken().length() < 10) {
            throw new InvalidAuthenticationToken("Invalid or expired TOKEN provided please check the token");
        }


        if (!walletRepo.existsById(request.getAccountNo())) {
            throw new AccountNotFoundException("Account with ID '" + request.getAccountNo() + "' does not exist");
        }

        return true;
    }

    @Override
    public Double calculateFees(Double amount) {

        return amount + (amount * 0.3);
    }

    @Override
    public boolean pay(Double finalAmount, paymentRequestDto request) {

        CreateWalletModal wallet = walletRepo.findById(request.getAccountNo())
                .orElseThrow(() -> new AccountNotFoundException("Account with ID '" + request.getAccountNo() + "' does not exist"));


        if (wallet.getAmount() < finalAmount) {
            throw new InsufficientBalanceException("Insufficient balance in account '" + request.getAccountNo()
                    + "'. Required: " + finalAmount + ", Available: " + wallet.getAmount());
        }

        // 3. Perform the debit operation
        wallet.setAmount(wallet.getAmount() - finalAmount);
        walletRepo.save(wallet);

        // 4. Log the transaction to the PaymentTrack table
        int transactionId = new Random().nextInt(1000000); // Generate a secure 6-digit transaction ID
        PaymentTrack newRecord = new PaymentTrack();
        newRecord.setTransactionId(transactionId);
        newRecord.setStatus("SUCCESS");
        newRecord.setMode("PAYPAL");
        newRecord.setAmount(finalAmount);
        paymentRepo.save(newRecord);

        return true;
    }
}
