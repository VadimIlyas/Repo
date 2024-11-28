package com.client.unibell.service;

import com.client.unibell.controller.SaveContactRequest;
import com.client.unibell.model.Client;
import com.client.unibell.model.Contact;
import com.client.unibell.model.Type;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ClientService {

    List<Client> getAllClients();

    Client saveClient(Client client);

    Client getClientById(Long id);

    List<Contact> getContactsByClientId(Long clientId);

    Contact saveContact(SaveContactRequest saveContactRequest) throws Exception;

    List<Contact> getOneTypeContactsByClientId(Long clientId, Type type);
}
