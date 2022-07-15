package com.hashkart.user.repositories;

import com.hashkart.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("from User u where u.username=:username")
    public User findByUsername(@Param("username")String username);

}
