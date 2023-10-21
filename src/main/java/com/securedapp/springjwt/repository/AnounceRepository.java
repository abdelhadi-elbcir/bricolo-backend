package com.securedapp.springjwt.repository;

import com.securedapp.springjwt.models.Announce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnounceRepository extends JpaRepository<Announce, Long> {
}
