package com.dimtechApp.dimtechApp.repository;

import com.dimtechApp.dimtechApp.models.Convidado;
import com.dimtechApp.dimtechApp.models.Evento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author dougl
 */
public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
    
    Iterable<Convidado> findByEvento(Evento evento);
    
    Convidado findByRg(String Rg);
    
}
