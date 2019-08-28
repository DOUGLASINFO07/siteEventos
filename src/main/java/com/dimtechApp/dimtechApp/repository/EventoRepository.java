/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimtechApp.dimtechApp.repository;

import com.dimtechApp.dimtechApp.models.Evento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author dougl
 */
public interface EventoRepository extends CrudRepository<Evento, String> {
    
    Evento findByCodigo(long codigo);
    
}
