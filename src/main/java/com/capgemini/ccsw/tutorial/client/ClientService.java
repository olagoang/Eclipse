package com.capgemini.ccsw.tutorial.client;

import java.util.List;

import com.capgemini.ccsw.tutorial.client.model.Client;
import com.capgemini.ccsw.tutorial.client.model.ClientDto;

public interface ClientService {

    /**
     * Método para recuperar todas las
     * {@link com.capgemini.ccsw.tutorial.client.model.Client}
     * 
     * @return
     */
    List<Client> findAll();

    Client findClientById(Long id);

    boolean nameEqual(String name);

    void save(Long id, ClientDto dto);

    void delete(Long id);

}
