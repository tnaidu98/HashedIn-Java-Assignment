package com.hashkart.payment.repositories;

import com.hashkart.payment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("from Payment p where p.user_id=:user_id")
    public Payment findByUser_Id(@Param("user_id")int user_id);
}
