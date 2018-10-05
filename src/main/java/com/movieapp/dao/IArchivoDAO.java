package com.movieapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.model.Archivo;

public interface IArchivoDAO extends JpaRepository<Archivo, Integer>{

	Archivo findOneByIdPelicula(int idPelicula);
}
