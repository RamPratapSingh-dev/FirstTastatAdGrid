package com.learning.first.Interfaces;

import com.learning.first.dto.paymentRequestDto;
import com.learning.first.dto.paymentResponseDto;

public interface PaymentInterface {



    default paymentResponseDto process(paymentRequestDto request)
    {

        if(!validateDetails( request))
        {

            return new paymentResponseDto("Failed invalid details ","no amount debited",request.getPaymentType());
        }

        Double finalAmount = calculateFees(request.getAmount());


        if(pay(finalAmount))
        {

            generateRecipt(request.getAmount(), finalAmount);
            return new paymentResponseDto("payment success",finalAmount.toString(),request.getPaymentType());
        }else
        {

            return new paymentResponseDto("Failed unexpexted error occured ","no amount debited",request.getPaymentType());
        }

    }
    boolean validateDetails(paymentRequestDto request);
    Double calculateFees( Double amount);
    boolean pay( Double finalAmount);
    default void generateRecipt( Double amount, Double finalAmount)
    {
        System.out.println("============= Recipt ===================");
        System.out.println("Entered amount = "+ amount);
        System.out.println("final Amount after calculating the interest to Pay = "+ finalAmount);
        System.out.println("Total amount processed = "+ finalAmount);
    }

}