package com.payment.demo.DTO;

import com.payment.demo.Domain.Payment;
import com.payment.demo.Model.PaymentReq;
import org.springframework.stereotype.Repository;


@Repository
public class PaymentDto {
    public Payment insertPayment(PaymentReq paymentReq) {
        Payment paymentEntity = Payment.builder()
                .payMethod("card")
                .impUid(paymentReq.imp_uid)
                .merchantUid(paymentReq.merchant_uid)
                .amount(paymentReq.amount)
                .buyerAddr(paymentReq.address)
                .buyerPostcode("10810")
                //.userId()
                .build();
        return paymentEntity;
    }
}
