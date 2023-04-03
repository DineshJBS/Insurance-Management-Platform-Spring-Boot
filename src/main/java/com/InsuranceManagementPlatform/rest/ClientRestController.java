package com.InsuranceManagementPlatform.rest;

import com.InsuranceManagementPlatform.entity.Client;
import com.InsuranceManagementPlatform.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientRestController {

    private ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> findAll() {

        return clientService.findAll();
    }

    // api/clent/{clientId}

    @GetMapping("/clients/{clientId}")
    public Client findById(@PathVariable int clientId) {

        Client client = clientService.findById(clientId);

        if (client == null) throw new RuntimeException("Client id not found " + clientId);

        return client;
    }

    // POST /api/clients

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client theClient) {

        theClient.setClientId(0);

        Client postClient = clientService.addClient(theClient);

        return postClient;
    }

    // PUT /api/clients/{id}:

    @PutMapping("/clients/{clientId}")
    public Client updateClient(@PathVariable int clientId, @RequestBody Client theClient) {

        // getting the client passed in URL
        Client tempClient = clientService.findById(clientId);
        if (tempClient == null) throw new RuntimeException("Client id not found to update" + clientId);
        else {
            // updating the client
            tempClient = clientService.save(theClient);
        }
        return tempClient;
    }

    //  DELETE /api/clients/{id}

    @DeleteMapping("/clients/{clientId}")
    public String deleteClient(@PathVariable int clientId) {
        Client tempClient = clientService.findById(clientId);
        if (tempClient == null) throw new RuntimeException("Client id not found to update" + clientId);
        else {
            // updating the client
            clientService.deleteById(clientId);
        }

        return "Client deleted : " + clientId;
    }


}
