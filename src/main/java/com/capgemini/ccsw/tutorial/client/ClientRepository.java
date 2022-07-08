package com.capgemini.ccsw.tutorial.client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.tutorial.client.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("select c from Client c where (name = :name) ")
    Client findByName(@Param("name") String name);

}
