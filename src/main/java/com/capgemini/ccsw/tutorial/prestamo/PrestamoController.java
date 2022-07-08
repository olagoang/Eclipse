package com.capgemini.ccsw.tutorial.prestamo;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.tutorial.config.mapper.BeanMapper;
import com.capgemini.ccsw.tutorial.prestamo.model.Prestamo;
import com.capgemini.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.capgemini.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

@RequestMapping(value = "/prestamo")
@RestController
@CrossOrigin(origins = "*")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @Autowired
    BeanMapper beanMapper;

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param dto
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<PrestamoDto> findPage(@RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "client", required = false) String client,
            @RequestParam(value = "fecha", required = false) Date fecha, @RequestBody PrestamoSearchDto dto) {

        return this.beanMapper.mapPage(this.prestamoService.findPage(title, client, fecha, dto), PrestamoDto.class);

    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<PrestamoDto> findAll() {

        List<Prestamo> prestamos = this.prestamoService.findAll();

        return this.beanMapper.mapList(prestamos, PrestamoDto.class);
    }

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param id
     * @param data datos de la entidad
     */

    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody PrestamoDto data) {

        this.prestamoService.save(id, data);

    }

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param id PK de la entidad
     */

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id) {
        this.prestamoService.delete(id);

    }

    @RequestMapping(path = "/games", method = RequestMethod.GET)
    public List<PrestamoDto> findByIdGameAndFechas(@RequestParam(value = "idGame", required = true) Long idGame,
            @RequestParam(value = "fechaOut", required = true) Date fechaOut,
            @RequestParam(value = "fechaIn", required = true) Date fechaIn) {

        List<Prestamo> prestamos = this.prestamoService.findByIdAndFechas(idGame, fechaOut, fechaIn);

        return this.beanMapper.mapList(prestamos, PrestamoDto.class);
    }

    @RequestMapping(path = "/clients", method = RequestMethod.GET)
    public List<PrestamoDto> findByIdClientAndFechas(@RequestParam(value = "idClient", required = true) Long idClient,
            @RequestParam(value = "fechaOut", required = true) Date fechaOut,
            @RequestParam(value = "fechaIn", required = true) Date fechaIn) {

        List<Prestamo> prestamos = this.prestamoService.findByClientAndFechas(idClient, fechaOut, fechaIn);

        return this.beanMapper.mapList(prestamos, PrestamoDto.class);
    }

}
