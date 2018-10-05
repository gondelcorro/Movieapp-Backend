package com.movieapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.dao.IRatingDAO;
import com.movieapp.model.Rating;
import com.movieapp.service.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService{

	@Autowired
	private IRatingDAO dao;
	
	@Override
	public int registrar(Rating rating) {
		int rpta = 0;
		rpta = dao.save(rating) != null ? rating.getIdRating() : 0 ;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public int modificar(Rating rating) {
		int rpta = 0;
		rpta = dao.save(rating) != null ? rating.getIdRating() : 0 ;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public List<Rating> listar() {
		return dao.findAll();
	}

	@Override
	public Rating obtener(Integer id) {
		return dao.getOne(id);
	}

}
