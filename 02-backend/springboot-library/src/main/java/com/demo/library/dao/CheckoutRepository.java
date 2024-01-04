package com.demo.library.dao;

import com.demo.library.entity.Checkout;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);

    List<Checkout> findBooksByUserEmail(String userEmail);
}
