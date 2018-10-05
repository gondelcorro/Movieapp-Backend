package com.movieapp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.movieapp.service.IArchivoService;
import com.movieapp.model.Archivo;
import com.movieapp.model.Pelicula;
import com.movieapp.service.IPeliculaService;

@RestController
@RequestMapping("/dashboard/pelicula")
public class PeliculaController {
	
	@Autowired
	private IPeliculaService service;
	@Autowired
	private IArchivoService serviceArchivo;
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> registrar(@RequestBody  Pelicula pelicula) {
		Pelicula rpta = null;
		try {
			rpta = service.registrar(pelicula);
		} catch (Exception e) {
			return new ResponseEntity<Pelicula>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Pelicula>(rpta,HttpStatus.OK);
	}
	
	@GetMapping(value="/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pelicula>> listar(){
		List<Pelicula> peliculas = new ArrayList<>();
		try {
			peliculas = service.listar();	
		} catch (Exception e) {
			return new ResponseEntity<List<Pelicula>>(peliculas,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Pelicula>>(peliculas,HttpStatus.OK);
	}
	
	//ESTE ES UN LISTAR CON PAGINADOR
	@GetMapping(value="/listarPageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Pelicula>> listar(Pageable pageable){
		Page<Pelicula> peliculas = null;
		try {
			peliculas = service.listarPorPagina(pageable);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Page<Pelicula>>(peliculas,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<Pelicula>>(peliculas,HttpStatus.OK);
	}
	
	@GetMapping(value="/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> obtener(@PathVariable("id") Integer id){
		Pelicula pelicula = null;
		try {
			pelicula = service.obtener(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Pelicula>(pelicula,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Pelicula>(pelicula,HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Pelicula pelicula) {
		int rpta = 0;
		try {
			service.modificar(pelicula);
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
	
	//el archivo se llama file porque asi llega desde angular!! los archivos img, pdfs.. se reciben como multipartfile
	@PostMapping(value = "/guardarArchivo/{idPelicula}")
	public ResponseEntity<Integer> guardarArchivo(@PathVariable("idPelicula") Integer idPelicula, @RequestParam("file") MultipartFile file) throws IOException {
		int rpta = 0;
		Archivo ar = new Archivo();
		ar.setValue(file.getBytes());
		ar.setIdPelicula(idPelicula);
		try {
			rpta = serviceArchivo.guardar(ar); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	@GetMapping(value = "/leerArchivo/{idPelicula}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idPelicula") Integer idPelicula) throws IOException {
				
		byte[] arr = serviceArchivo.leerArchivo(idPelicula); 
		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}
}
