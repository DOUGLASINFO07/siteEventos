/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimtechApp.dimtechApp.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author douglas borges egidio
 * @author DouglasInfo07
 * @since 27/08/2019
 */

@Entity
public class Convidado implements Serializable {
    
    @Id
    @NotEmpty
    private String rg;
    @NotEmpty
    private String nomeConvidado;
    
    @ManyToOne
    private Evento evento;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }
    
    
    
}
