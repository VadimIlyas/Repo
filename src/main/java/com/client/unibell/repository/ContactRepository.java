package com.client.unibell.repository;

import com.client.unibell.model.Contact;
import com.client.unibell.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT c FROM Contact c WHERE c.id = :clientId")
    List<Contact> findByClientId(@Param("client_id")Long clientId);

    @Query("SELECT c FROM Contact c WHERE c.id = :clientId AND c.type = :contactType")
    List<Contact> findByClientIdAndType(@Param("client_id") Long clientId, @Param("contact_type") Type type);

    @Query(value = "INSERT into contact(client_id, type, value) values (:clientId, :type, :value)", nativeQuery = true)
    @Modifying
    Contact saveContactByClientId(Long clientId, Type type, String value);
}
