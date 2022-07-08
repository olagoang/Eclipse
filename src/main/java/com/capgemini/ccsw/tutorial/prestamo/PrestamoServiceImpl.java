package com.capgemini.ccsw.tutorial.prestamo;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.client.ClientService;
import com.capgemini.ccsw.tutorial.game.GameService;
import com.capgemini.ccsw.tutorial.prestamo.model.Prestamo;
import com.capgemini.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.capgemini.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

@Service
@Transactional
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    GameService gameService;

    /**
     * {@inheritDoc}
     */

    @Override
    public List<Prestamo> findAll() {

        List<Prestamo> test = (List<Prestamo>) this.prestamoRepository.findAll();
        System.out.println("asdfasdf " + test.toString());

        return (List<Prestamo>) this.prestamoRepository.findAll();
    }
    /*
     * @Override public void save(Long id, PrestamoDto data) { Prestamo prestamo =
     * null;
     * 
     * if (id != null) prestamo = this.prestamoRepository.findById(id).orElse(null);
     * else prestamo = new Prestamo();
     * 
     * BeanUtils.copyProperties(data, prestamo, "id");
     * 
     * this.prestamoRepository.save(prestamo);
     * 
     * }
     */

    @Override
    public void delete(Long id) {
        this.prestamoRepository.deleteById(id);

    }

    @Override
    public Page<Prestamo> findPage(String title, String client, Date fecha, PrestamoSearchDto dto) {

        return (Page<Prestamo>) this.prestamoRepository.findPage(title, client, fecha, dto.getPageable());
    }

    @Override
    public void save(Long id, PrestamoDto data) {

        Prestamo p = null;

        if (id != null) {
            p = this.prestamoRepository.findById(id).orElse(null);

        } else {
            p = new Prestamo();
        }

        BeanUtils.copyProperties(data, p, "id", "game", "client");
        p.setClient(this.clientService.findClientById(data.getClient().getId()));
        p.setGame(this.gameService.findGameById(data.getGame().getId()));

        this.prestamoRepository.save(p);
    }

    @Override
    public List<Prestamo> findByIdAndFechas(Long idGame, Date fechaOut, Date fechaIn) {

        return (List<Prestamo>) this.prestamoRepository.findByIdAndFechas(idGame, fechaOut, fechaIn);
    }

    @Override
    public List<Prestamo> findByClientAndFechas(Long idClient, Date fechaOut, Date fechaIn) {
        return (List<Prestamo>) this.prestamoRepository.findByClientAndFechas(idClient, fechaOut, fechaIn);
    }

}
