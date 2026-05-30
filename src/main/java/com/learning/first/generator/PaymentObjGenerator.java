package com.learning.first.generator;

import com.learning.first.Interfaces.PaymentInterface;
import com.learning.first.Service.CreditCard;
import com.learning.first.Service.PayPal;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class PaymentObjGenerator {


    private final Map<String, PaymentInterface> processors;

    public PaymentObjGenerator(Map<String, PaymentInterface> processors) {
        this.processors = processors;
    }

    public  PaymentInterface getProcessor(String type) {

        PaymentInterface processor = processors.get(type);
        if (processor == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + type);
        }
        return processor;
    }


}
