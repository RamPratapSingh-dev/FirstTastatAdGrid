package com.learning.first.Controller;

import com.learning.first.dto.paymentRequestDto;
import com.learning.first.dto.paymentResponseDto;
import com.learning.first.generator.PaymentObjGenerator;
import com.learning.first.Interfaces.PaymentInterface;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
public class PaymentController {


    private final PaymentObjGenerator paymentObjGenerator;

    public PaymentController(PaymentObjGenerator paymentObjGenerator) {
        this.paymentObjGenerator = paymentObjGenerator;
    }

    @PostMapping("/proceed")
    public ResponseEntity<paymentResponseDto> process(@Valid @RequestBody paymentRequestDto request) {
        PaymentInterface processor = paymentObjGenerator.getProcessor(request.getPaymentType());


        return ResponseEntity.ok(processor.process(request));
    }
}