package com.dimtechApp.dimtechApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.dimtechApp.dimtechApp.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}