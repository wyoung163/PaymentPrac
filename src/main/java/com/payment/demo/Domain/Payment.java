package com.payment.demo.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * 결제 정보 entity
 *
 * 결제 id
 * 결제 방법
 * 주문 번호
 * 구매 번호
 * 가격
 * 구매자 주소
 * 구매자 우편
 * 구매자 id
 * @author USER
 *
 */
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    @Column(nullable = false, length = 100)
    private String payMethod;

    //주문번호
    @Column(nullable = false, length = 100)
    private String impUid;

    //구매자 번호
    @Column(nullable = false, length = 100)
    private String merchantUid;

    //가격
    @Column(nullable = false)
    private int amount;

    //구매자 주소
    @Column(nullable = false, length = 100)
    private String buyerAddr;

    //구매자 우편번호
    @Column(nullable = false, length = 100)
    private String buyerPostcode;

    //사용자 id
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @Builder
    public Payment(long paymentId, String payMethod, String impUid, String merchantUid, int amount, String buyerAddr, String buyerPostcode, User userId) {
        this.paymentId = paymentId;
        this.payMethod = payMethod;
        this.impUid = impUid;
        this.merchantUid = merchantUid;
        this.amount = amount;
        this.buyerAddr = buyerAddr;
        this.buyerPostcode = buyerPostcode;
        this.userId = userId;
    }
}