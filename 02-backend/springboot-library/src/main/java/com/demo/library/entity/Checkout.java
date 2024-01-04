package com.demo.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@jakarta.persistence.Entity
@Table(name = "checkout")
@Data
public class Checkout {
    public Checkout() {}

    public Checkout(String userEmail, String checkoutDate, String returnDate, Long bookId) {
        this.userEmail = userEmail;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
        this.bookId = bookId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    String userEmail;

    @Column(name = "checkout_date")
    String checkoutDate;

    @Column(name = "return_date")
    String returnDate;

    @Column(name = "book_id")
    Long bookId;
}
