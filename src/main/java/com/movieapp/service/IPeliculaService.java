package com.movieapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.movieapp.model.Pelicula;

public interface IPeliculaService {
	
	Pelicula registrar(Pelicula pelicula);
	void eliminar(Integer id);
	int modificar(Pelicula pelicula);
	List<Pelicula> listar();
	Pelicula obtener(Integer id);
	Page<Pelicula> listarPorPagina(Pageable pageable);

}
