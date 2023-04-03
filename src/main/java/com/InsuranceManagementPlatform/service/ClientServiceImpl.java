package com.InsuranceManagementPlatform.service;

import com.InsuranceManagementPlatform.dao.ClientRepository;
import com.InsuranceManagementPlatform.entity.Client;
import org.springframework.stereotype.Service;

;
import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {


        return  clientRepository.findAll();
    }

    @Override
    public Client findById(int clientId) {
        Optional<Client> result = clientRepository.findById(clientId);

        if(result.isPresent()) return result.get();
        else throw new RuntimeException("Did not find the clientId ");

    }

    @Override
    public Client addClient(Client theClient) {

        return clientRepository.save(theClient);
    }

    @Override
    public Client save(Client theClient) {
        return clientRepository.save(theClient);
    }

    @Override
    public void deleteById(int clientId) {
         clientRepository.deleteById(clientId);
    }


}
