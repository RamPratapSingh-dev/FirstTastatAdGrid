package com.learning.first.Service;

import com.learning.first.Interfaces.PaymentInterface;
import com.learning.first.exception.InvalidAuthenticationToken;
import com.learning.first.dto.paymentRequestDto;
import com.learning.first.modal.PaymentTrack;
import com.learning.first.repository.PaymentTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("PayPal")
public class PayPal implements PaymentInterface {

    @Autowired
    PaymentTrackRepository repo;

    Double FinalAmount;
    int transactionId;

    @Override
  public  boolean  validateDetails(paymentRequestDto request)
    {
       if(request.getToken().length()<10)
       {
           throw new InvalidAuthenticationToken("Invalid or expired TOKEN provided please check the token");
       }

        return true;
    }

    @Override
    public  Double calculateFees(Double amount)
    {

        FinalAmount = amount+(amount*0.3);
        return FinalAmount ;
    }



    @Override
    public boolean pay(Double finalAmount)
    {

        transactionId = new Random().nextInt(10);

        PaymentTrack newRecord = new PaymentTrack();
        newRecord.setTransactionId(transactionId);
        newRecord.setStatus("SUCCESS");
        newRecord.setMode("PAYPAL");
        newRecord.setAmount(FinalAmount);
        repo.save(newRecord);

        return true;
   }
}
