package com.movieapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.dao.IUsuarioDAO;
import com.movieapp.model.Usuario;
import com.movieapp.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDAO dao;
	
	@Override
	public int registrar(Usuario usuario) {
		int rpta = 0;
		rpta = dao.save(usuario) != null ? usuario.getIdUser() : 0 ;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(Integer id) {
		dao.delete(id);
	}

	@Override
	public int modificar(Usuario usuario) {
		int rpta = 0;
		rpta = dao.save(usuario) != null ? usuario.getIdUser() : 0 ;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Override
	public Usuario obtener(Integer id) {
		return dao.getOne(id);
	}

}
