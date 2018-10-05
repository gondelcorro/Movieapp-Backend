package com.movieapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{

}
