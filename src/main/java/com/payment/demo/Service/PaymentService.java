package com.payment.demo.Service;

import com.payment.demo.DTO.PaymentDto;
import com.payment.demo.Domain.Payment;
import com.payment.demo.Model.PaymentReq;
import com.payment.demo.Repository.CommodityRepository;
import com.payment.demo.Repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final CommodityRepository commodityRepository;
    private final PaymentDto paymentDto;

    /** DB에 저장된 해당 상품의 가격과 실제 결제된 가격 비교 **/
    public boolean doPriceComparison(int amount, String commodity){
        int dbPrice = commodityRepository.findByName(commodity).getPrice();
        if(dbPrice == amount){
            return true;
        }
        return false;
    }

    /** 결제가 올바르게 진행되었으면 결제 테이블에 해당 내역 저장 **/
    public long insertPayment(PaymentReq paymentReq){
        Payment payment = paymentRepository.save(
                paymentDto.insertPayment(paymentReq));

        if(payment.getPaymentId() < 0){
            return -1;
        }
        return payment.getPaymentId();
    }
}
