package com.InsuranceManagementPlatform.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.InsuranceManagementPlatform.entity.Client;
import com.InsuranceManagementPlatform.service.ClientService;

class ClientRestControllerTest {

    private ClientService clientService;
    private ClientRestController clientController;

    @BeforeEach
    void setUp() {
        clientService = mock(ClientService.class);
        clientController = new ClientRestController(clientService);
    }

    @Test
    void testFindAll() {

        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "Dinesh", "Dm", "cbe", "988464" ));
        clients.add(new Client(2, "Dinesh", "Dm", "cbe", "988464" ));
        when(clientService.findAll()).thenReturn(clients);


        List<Client> result = clientController.findAll();


        assertEquals(clients, result);
    }

    @Test
    void testFindById() {

        int clientId = 123;
        Client client = new Client(clientId, "Dinesh", "Dm", "cbe", "988464" );
        when(clientService.findById(clientId)).thenReturn(client);


        Client result = clientController.findById(clientId);


        assertEquals(client, result);
    }

    @Test
    void testFindByIdNotFound() {

        int clientId = 123;
        when(clientService.findById(clientId)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> clientController.findById(clientId));
    }

    @Test
    void testAddClient() {

        Client client = new Client(1, "Dinesh", "Dm", "cbe", "988464" );
        when(clientService.addClient(client)).thenReturn(client);


        Client result = clientController.addClient(client);


        assertEquals(client, result);
    }

    @Test
    void testUpdateClient() {

        int clientId = 123;
        Client client = new Client(1, "Dinesh", "Dm", "cbe", "988464" );
        when(clientService.findById(clientId)).thenReturn(client);
        when(clientService.save(client)).thenReturn(client);


        Client result = clientController.updateClient(clientId, client);


        assertEquals(client, result);
    }

    @Test
    void testUpdateClientNotFound() {

        int clientId = 123;
        Client client = new Client(clientId, "Dinesh", "Dm", "cbe", "988464" );
        when(clientService.findById(clientId)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> clientController.updateClient(clientId, client));
    }

    @Test
    void testDeleteClient() {

        int clientId = 123;
        Client client =new Client(clientId, "Dinesh", "Dm", "cbe", "988464" );
        when(clientService.findById(clientId)).thenReturn(client);


        String result = clientController.deleteClient(clientId);


        assertEquals("Client deleted : " + clientId, result);
        verify(clientService, times(1)).deleteById(clientId);
    }

    @Test
    void testDeleteClientNotFound() {

        int clientId = 123;
        when(clientService.findById(clientId)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> clientController.deleteClient(clientId));
    }
}
