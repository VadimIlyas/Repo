package com.client.unibell.repository;

import com.client.unibell.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@EnableJpaRepositories
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client>getClientById(Long id);
}
