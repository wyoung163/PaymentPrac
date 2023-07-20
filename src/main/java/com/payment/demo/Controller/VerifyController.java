package com.payment.demo.Controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//서버 검증
@Slf4j
@RequiredArgsConstructor
@Component
//@Controller
//@RequestMapping("/verifyIamport")
public class VerifyController {
    /** IamPort 결제 검증 컨트롤러 **/
    private final IamportClient iamportClient;

    @Value("${RestApiKey}")
    private String key;

    @Value("${RestApiSecret}")
    private String secret;

    /** 생성자를 통해 REST API와 REST API secret 입력 **/
    public VerifyController() {
        this.iamportClient = new IamportClient(key, secret);
    }

    /** PG사 결괏값을 통해 아임포트 토큰 발행 **/
    //@PostMapping("/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(@PathVariable String imp_uid) throws IamportResponseException, IOException {
        log.info("paymentByImpUid 진입");
        return iamportClient.paymentByImpUid(imp_uid);
    }
}
