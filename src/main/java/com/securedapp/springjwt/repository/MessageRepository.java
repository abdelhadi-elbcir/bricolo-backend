package com.securedapp.springjwt.repository;

import com.securedapp.springjwt.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository  extends JpaRepository<Message , Long> {
}
