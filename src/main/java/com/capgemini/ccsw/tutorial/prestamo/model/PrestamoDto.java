package com.capgemini.ccsw.tutorial.prestamo.model;

import java.sql.Date;

import com.capgemini.ccsw.tutorial.client.model.ClientDto;
import com.capgemini.ccsw.tutorial.game.model.GameDto;

public class PrestamoDto {

    private Long id;
    private GameDto game;
    private ClientDto client;
    private Date fechaIn;
    private Date fechaOut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameDto getGame() {
        return game;
    }

    public void setGame(GameDto game) {
        this.game = game;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Date getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(Date fechaOut) {
        this.fechaOut = fechaOut;
    }

}
