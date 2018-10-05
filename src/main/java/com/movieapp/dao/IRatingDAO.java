package com.movieapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Rating;

@Repository
public interface IRatingDAO extends JpaRepository<Rating, Integer>{

}
