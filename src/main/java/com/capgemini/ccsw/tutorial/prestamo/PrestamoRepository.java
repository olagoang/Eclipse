package com.capgemini.ccsw.tutorial.prestamo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.tutorial.prestamo.model.Prestamo;

public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param page
     * @return
     */
    Page<Prestamo> findAll(Pageable pageable);

    @Query("select p from Prestamo p" + " where (:title is null or p.game.title like '%'||:title||'%' ) "
            + "and ( :fecha is null or  to_date(:fecha,'YYYY/MM/DD') between to_date(p.fechaIn,'YYYY/MM/DD') and to_date(p.fechaOut,'YYYY/MM/DD') )"
            + " and (:client is null or p.client.name like '%'||:client||'%')")

    Page<Prestamo> findPage(@Param("title") String title, @Param("client") String client, @Param("fecha") Date fecha,
            Pageable pageable);

    @Query("select p from Prestamo p " + "where p.game.id=:idGame "
            + "and ( (to_date(p.fechaIn,'YYYY/MM/DD') > to_date(:fechaIn,'YYYY/MM/DD') and to_date(p.fechaIn,'YYYY/MM/DD') < to_date(:fechaOut,'YYYY/MM/DD')) "
            + "    or ( to_date(p.fechaIn,'YYYY/MM/DD') <= to_date(:fechaIn,'YYYY/MM/DD') and to_date(p.fechaOut,'YYYY/MM/DD') >= to_date(:fechaOut,'YYYY/MM/DD') ) "
            + "    or( to_date(p.fechaOut,'YYYY/MM/DD') > to_date(:fechaIn,'YYYY/MM/DD') and to_date(p.fechaOut,'YYYY/MM/DD') < to_date(:fechaOut,'YYYY/MM/DD'))"
            + ")")
    List<Prestamo> findByIdAndFechas(Long idGame, Date fechaOut, Date fechaIn);

    @Query("select p from Prestamo p " + "where p.client.id=:idClient "
            + "and ( (to_date(p.fechaIn,'YYYY/MM/DD') > to_date(:fechaIn,'YYYY/MM/DD') and to_date(p.fechaIn,'YYYY/MM/DD') < to_date(:fechaOut,'YYYY/MM/DD')) "
            + " or ( to_date(p.fechaIn,'YYYY/MM/DD') <= to_date(:fechaIn,'YYYY/MM/DD') and to_date(p.fechaOut,'YYYY/MM/DD') >= to_date(:fechaOut,'YYYY/MM/DD') ) "
            + "or( to_date(p.fechaOut,'YYYY/MM/DD') > to_date(:fechaIn,'YYYY/MM/DD') and to_date(p.fechaOut,'YYYY/MM/DD') < to_date(:fechaOut,'YYYY/MM/DD'))"
            + ")")
    List<Prestamo> findByClientAndFechas(Long idClient, Date fechaOut, Date fechaIn);

}
