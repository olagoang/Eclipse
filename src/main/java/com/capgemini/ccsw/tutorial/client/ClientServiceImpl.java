package com.capgemini.ccsw.tutorial.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.client.model.Client;
import com.capgemini.ccsw.tutorial.client.model.ClientDto;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {

        return (List<Client>) this.clientRepository.findAll();

    }

    /**
     * Método para recuperar todas las Category
     * 
     * @return
     */

    /**
     * Método para crear o actualizar una Category
     * 
     * @param dto
     * @return
     */
    @Override
    public void save(Long id, ClientDto dto) {

        Client client = null;

        if (!this.nameEqual(dto.getName())) {

            if (id == null) {
                client = new Client();

            } else {
                client = this.clientRepository.findById(id).orElse(null);
            }

            // if(dto.getName()!= findAll().getName)

            client.setName(dto.getName());
            this.clientRepository.save(client);
        }
    }

    /**
     * Método para borrar una Category
     * 
     * @param id
     */

    @Override
    public void delete(Long id) {

        this.clientRepository.deleteById(id);

    }

    // Si es false no encuentra cliente y si se puede hacer la operacion
    public boolean nameEqual(String name) {
        boolean result = true;
        Client cl = null;

        cl = this.clientRepository.findByName(name);

        if (cl == null)
            result = false;

        return result;
    }

    @Override
    public Client findClientById(Long id) {

        return this.clientRepository.findById(id).orElse(null);
    }

}
