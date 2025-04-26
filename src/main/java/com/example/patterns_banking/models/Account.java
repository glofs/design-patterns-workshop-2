package com.example.patterns_banking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //para que solo se persistan las Account en la DB
public abstract class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String accountNumber;
  private Double balance;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  @JsonBackReference //para evitar ciclos infinitos
  private Customer customer;

  public abstract Double calculateDepositFee(Double amount);

  public void deposit(Double amount) {
    double fee = calculateDepositFee(amount);
    this.balance += amount - fee;
  }
}
