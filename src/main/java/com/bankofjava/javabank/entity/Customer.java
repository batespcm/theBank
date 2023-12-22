package com.bankofjava.javabank.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "customerDetails")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prefix;
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String pronouns;
    private String firstLineAddress;
    private String county;
    private String postcode;
    private String accountNumber;
    private String email;
    private BigDecimal accountBalance;
    private String phoneNumber;
    private String accountStatus;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;
}
