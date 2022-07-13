package com.assignment.assignment3.repositories;

import com.assignment.assignment3.entities.ShowDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowDetailsRepository extends JpaRepository<ShowDetails, String> {
}
