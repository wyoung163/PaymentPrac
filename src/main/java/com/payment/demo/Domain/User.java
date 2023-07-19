package com.payment.demo.Domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 회원 정보 entity
 *
 * 사용자 id
 * 닉네임
 * 이메일
 * 비밀번호
 *
 */
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(long userId, String nickname, String email, String password) {
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}
