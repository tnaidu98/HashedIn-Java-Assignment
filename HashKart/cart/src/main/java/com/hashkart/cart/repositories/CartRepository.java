package com.hashkart.cart.repositories;

import com.hashkart.cart.entities.Cart_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<Cart_Details, Integer> {

    @Query(value = "SELECT SUM(price*qty) FROM Cart_Details cd where cd.user_id=:user_id", nativeQuery = true)
    double findTotalPrice(@Param("user_id") int user_id);

    @Query("from Cart_Details cd where cd.user_id=:user_id")
    List<Cart_Details> findAllByUserId(@Param("user_id") int user_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE from Cart_Details cd where cd.user_id=:user_id", nativeQuery = true)
    void deleteByUser_Id(@Param("user_id") int user_id);

}
