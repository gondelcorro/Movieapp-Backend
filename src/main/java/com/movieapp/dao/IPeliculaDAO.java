package com.movieapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Pelicula;

@Repository
public interface IPeliculaDAO extends JpaRepository<Pelicula, Integer>{

}
