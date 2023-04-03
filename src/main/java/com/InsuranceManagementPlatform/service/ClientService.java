package com.InsuranceManagementPlatform.service;

import com.InsuranceManagementPlatform.entity.Client;

import java.util.List;

public interface ClientService {

    public List<Client> findAll();

    public Client findById(int clientId);

    public Client addClient(Client theClient);

    public Client save(Client theClient);

    public void deleteById(int clientId);






}
