package com.movieapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.model.Usuario;
import com.movieapp.service.IUsuarioService;

@RestController
@RequestMapping("/dashboard/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Usuario usuario) {
		int rpta = 0;
		try {
			rpta = service.registrar(usuario);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta,HttpStatus.OK);
	}
	
	@GetMapping(value="/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> usuario = new ArrayList<>();
		try {
			usuario = service.listar();	
		} catch (Exception e) {
			return new ResponseEntity<List<Usuario>>(usuario,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Usuario>>(usuario,HttpStatus.OK);
	}
	
	@GetMapping(value="/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> obtener(@PathVariable("id") Integer id){
		Usuario usuario = null;
		try {
			usuario = service.obtener(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Usuario>(usuario,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Usuario usuario) {
		int rpta = 0;
		try {
			service.modificar(usuario);
			rpta=1;
		} catch (Exception e) {
			new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable("id") Integer id) {
		int resultado = 0;
		try {
			service.eliminar(id);
			resultado=1;
		} catch (Exception e) {
			new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
}
