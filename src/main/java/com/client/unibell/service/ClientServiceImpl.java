package com.client.unibell.service;

import com.client.unibell.controller.SaveContactRequest;
import com.client.unibell.model.Client;
import com.client.unibell.model.Contact;
import com.client.unibell.model.Type;
import com.client.unibell.repository.ClientRepository;
import com.client.unibell.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    public ClientServiceImpl(ClientRepository clientRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
    }


    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contact> getContactsByClientId(Long clientId) {
        return contactRepository.findByClientId(clientId);
    }

    @Override
    @Transactional
    public Contact saveContact(SaveContactRequest saveContactRequest) throws Exception {
        Client client = clientRepository.getClientById(saveContactRequest.getClientId()).orElseThrow(() -> new Exception("Не найден клиент с id " + saveContactRequest.getClientId()));
        return contactRepository.saveContactByClientId(client.getId(), saveContactRequest.getContactType(), saveContactRequest.getContactValue());
    }

    @Override
    public List<Contact> getOneTypeContactsByClientId(Long clientId, Type type) {
        return contactRepository.findByClientIdAndType(clientId, type);
    }
}
