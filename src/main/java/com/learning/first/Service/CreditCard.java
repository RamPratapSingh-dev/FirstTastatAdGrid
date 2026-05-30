package com.learning.first.Service;

import com.learning.first.Interfaces.PaymentInterface;
import com.learning.first.dto.paymentRequestDto;
import com.learning.first.exception.InvalidAuthenticationToken;
import org.springframework.stereotype.Service;

@Service("CreditCard")
public class CreditCard  implements PaymentInterface {

    @Override
    public boolean validateDetails(paymentRequestDto request)
    {
        if(request.getToken().length()<10)
        {
            throw new InvalidAuthenticationToken("Invalid or expired TOKEN provided please check the token");
        }
        return true;
    }

    @Override
    public Double calculateFees(Double amount)
    {

        System.out.println("appliying 20% on the credit Card ");
        return amount+(amount*0.2);
    }

    @Override
    public boolean pay(Double finalAmount, paymentRequestDto request)
    {

        return true;
    }
}
