package com.movieapp.service;

import java.util.List;
import java.util.Optional;

import com.movieapp.model.Rating;

public interface IRatingService {
	
	int registrar(Rating rating);
	void eliminar(Integer id);
	int modificar(Rating rating);
	List<Rating> listar();
	Rating obtener(Integer id);

}
