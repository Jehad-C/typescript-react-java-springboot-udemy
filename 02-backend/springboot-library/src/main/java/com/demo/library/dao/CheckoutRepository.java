package com.demo.library.dao;

import com.demo.library.entity.Checkout;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);

    List<Checkout> findBooksByUserEmail(String userEmail);

    @Modifying
    @Query(value = "delete from Checkout where book_id = :book_id", nativeQuery = true)
    void deleteAllByBookId(@Param("book_id") Long bookId);
}
