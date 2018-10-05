package com.movieapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.dao.IArchivoDAO;
import com.movieapp.model.Archivo;
import com.movieapp.service.IArchivoService;

@Service
public class ArchivoServiceImpl implements IArchivoService {

	@Autowired
	private IArchivoDAO dao;

	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = dao.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}

	@Override
	public byte[]  leerArchivo(Integer idPelicula) {
		return 	dao.findOneByIdPelicula(idPelicula).getValue();

	}

}
