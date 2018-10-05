package com.movieapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.movieapp.dao.IPeliculaDAO;
import com.movieapp.model.Pelicula;
import com.movieapp.service.IPeliculaService;

@Service
public class PeliculaServiceImpl implements IPeliculaService{

	@Autowired
	private IPeliculaDAO dao;
	
	@Override
	public Pelicula registrar(Pelicula pelicula) {
		Pelicula rpta = null;
		try {
			rpta = dao.save(pelicula);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rpta;
	}

	@Override
	public void eliminar(Integer id) {
		dao.delete(id);
	}

	@Override
	public int modificar(Pelicula pelicula) {
		int rpta = 0;
		rpta = dao.save(pelicula) != null ? pelicula.getIdPelicula() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public List<Pelicula> listar() {
		return dao.findAll();
	}

	@Override
	public Pelicula obtener(Integer id) {
		return dao.getOne(id);
	}

	@Override
	public Page<Pelicula> listarPorPagina(Pageable pageable) {
		return dao.findAll(pageable);
	}

}
