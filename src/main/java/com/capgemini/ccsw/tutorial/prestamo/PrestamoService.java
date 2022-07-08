package com.capgemini.ccsw.tutorial.prestamo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.ccsw.tutorial.prestamo.model.Prestamo;
import com.capgemini.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.capgemini.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

public interface PrestamoService {

    Page<Prestamo> findPage(String title, String client, Date fecha, PrestamoSearchDto dto);

    List<Prestamo> findAll();

    // void save(Long id, PrestamoDto data);

    void delete(Long id);

    void save(Long id, PrestamoDto data);

    List<Prestamo> findByIdAndFechas(Long idGame, Date fechaOut, Date fechaIn);

    List<Prestamo> findByClientAndFechas(Long idClient, Date fechaOut, Date fechaIn);

}
