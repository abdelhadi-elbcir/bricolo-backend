package com.securedapp.springjwt.repository;

import com.securedapp.springjwt.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
