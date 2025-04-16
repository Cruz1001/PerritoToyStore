package com.perritotoystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.perritotoystore.model.entity.Brinquedo;
import com.perritotoystore.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/brinquedos")
public class BrinquedoController {
	@Autowired
	private BrinquedoService brinquedoService;

	@GetMapping
	public List<Brinquedo> getAllBrinquedos() {
		return  brinquedoService.getAllBrinquedos();
	}

	@PostMapping
	public ResponseEntity<Brinquedo> createBrinquedo(@RequestBody Brinquedo brinquedo) {
		Brinquedo   novoBrinquedo = brinquedoService.createBrinquedo(brinquedo);
		return  new  ResponseEntity<>(novoBrinquedo, HttpStatus.CREATED);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Brinquedo> getBrinquedoByCodigo(@PathVariable int codigo) {
		Brinquedo brinquedo = brinquedoService.getBrinquedoByCodigo(codigo);
		if (brinquedo != null) {
			return new ResponseEntity<>(brinquedo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deleteBrinquedo(@PathVariable int codigo) {
		boolean deleted = brinquedoService.deleteBrinquedo(codigo);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}			
}
