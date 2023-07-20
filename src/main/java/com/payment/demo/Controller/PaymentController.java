package com.payment.demo.Controller;

import com.payment.demo.Model.PaymentReq;
import com.payment.demo.Model.PaymentRes;
import com.payment.demo.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final VerifyController verifyController;
    private final PaymentService paymentService;

    @PostMapping("/payment/validate")
    public PaymentRes createPayment(@RequestBody PaymentReq paymentReq){
        try {
            // 포트원 결제 내역에 해당하는 내용과 결제 처리 결과 비교
            String result = verifyController.paymentByImpUid(paymentReq.imp_uid).toString();
            if(result == paymentReq.imp_uid){
                // DB의 실제 상품 가격과 결제 처리 결과 가격 비교
                if(paymentService.doPriceComparison(paymentReq.amount, paymentReq.commodity)){
                    // 같을 때만 결제 승인하고 결제 내역 저장
                    long paymentId = paymentService.insertPayment(paymentReq);
                    if(paymentId > -1){
                        return new PaymentRes(true);
                    }
                }
            }
            return new PaymentRes(false);
        } catch (Exception e){
            return new PaymentRes(false);
        }
    }
}
