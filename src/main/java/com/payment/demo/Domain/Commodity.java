package com.payment.demo.Domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * 상품 정보 entity
 *
 * 상품 id
 * 상품명
 * 가격
 *
 */
@NoArgsConstructor
@Entity
@Table(name = "User")
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long commodityId;

    @Column(nullable = false)
    private int price;

    @Builder
    public Commodity(long commodityId, int price) {
        this.commodityId = commodityId;
        this.price = price;
    }
}
