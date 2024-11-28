package com.client.unibell.controller;

import com.client.unibell.model.Client;
import com.client.unibell.model.Contact;
import com.client.unibell.model.Type;
import com.client.unibell.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

 private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.saveClient(client), HttpStatus.CREATED);
    }

    @PostMapping(value = "/saveContact", consumes = "application/json")
    public ResponseEntity<Contact> saveContact(@RequestBody SaveContactRequest contact) throws Exception {
        return new ResponseEntity<>(clientService.saveContact(contact), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping("/{clientId}/contacts")
    public ResponseEntity<List<Contact>> getContactsByClientId(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getContactsByClientId(clientId));
    }

    @GetMapping("/{clientId}/contacts/{type}")
    public ResponseEntity<List<Contact>> getOneTypeContactsByClientId(@PathVariable Long clientId, @PathVariable Type type) {
        return ResponseEntity.ok(clientService.getOneTypeContactsByClientId(clientId, type));
    }
}
