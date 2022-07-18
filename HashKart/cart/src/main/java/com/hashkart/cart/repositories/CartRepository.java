package com.hashkart.cart.repositories;

import com.hashkart.cart.entities.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartDetails, Integer> {

    @Query(value = "SELECT SUM(price*qty) FROM cart_details cd where cd.user_id=:user_id", nativeQuery = true)
    double findTotalPrice(@Param("user_id") int user_id);

    List<CartDetails> findAllByUserId(@Param("user_id") int user_id);

    @Modifying
    @Transactional
    void deleteByUserId(@Param("user_id") int user_id);

}
