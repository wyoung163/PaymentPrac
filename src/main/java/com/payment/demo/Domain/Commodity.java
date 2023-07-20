package com.payment.demo.Domain;

import lombok.*;

import javax.persistence.*;

/**
 * 상품 정보 entity
 *
 * 상품 id
 * 상품명
 * 가격
 *
 */
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long commodityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;
}
