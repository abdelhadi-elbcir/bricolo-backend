package com.securedapp.springjwt.repository;

import com.securedapp.springjwt.models.Ratting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RattingRepository extends JpaRepository<Ratting , Long> {
}
