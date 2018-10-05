package com.movieapp.service;

import java.util.List;
import java.util.Optional;

import com.movieapp.model.Usuario;

public interface IUsuarioService {
	
	int registrar(Usuario usuario);
	void eliminar(Integer id);
	int modificar(Usuario usuario);
	List<Usuario> listar();
	Usuario obtener(Integer id);

}
