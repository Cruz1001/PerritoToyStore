package com.perritotoystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perritotoystore.model.entity.Brinquedo;
import com.perritotoystore.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;
import java.util.List;



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
	
	//Criar brinquedo com imagem
	/*@PostMapping("/img") //imagem
	public ResponseEntity<Brinquedo> createBrinquedoImg(@RequestPart Brinquedo brinquedo, @RequestPart MultipartFile imageFile) throws IOException {
		byte[] imageBytes = imageFile.getBytes();

		brinquedo.setImg(imageBytes);
		brinquedo.setImgType(imageFile.getContentType());

		Brinquedo novoBrinquedo = brinquedoService.createBrinquedoImg(brinquedo, imageBytes);
		return  new  ResponseEntity<>(novoBrinquedo, HttpStatus.CREATED);
	}*/
	
	@PostMapping("/img")
	public ResponseEntity<?> createBrinquedoComImagem(@RequestBody JsonNode body) {
    try {
        JsonNode brinquedoNode = body.get("brinquedo");
        String imageBase64 = body.get("imageFile").asText();
 
        ObjectMapper mapper = new ObjectMapper();
        Brinquedo brinquedo = mapper.treeToValue(brinquedoNode, Brinquedo.class);
 
        if (imageBase64 != null && !imageBase64.isEmpty()) {
            if (imageBase64.contains(",")) {
                imageBase64 = imageBase64.split(",")[1];
            }
            byte[] imagem = Base64.getDecoder().decode(imageBase64);
            brinquedo.setImg(imagem);
        }
 
        Brinquedo novoBrinquedo = brinquedoService.createBrinquedo(brinquedo);
        return new ResponseEntity<>(novoBrinquedo, HttpStatus.CREATED);
 
    } catch (Exception e) {
        e.printStackTrace(); // PRA VER O ERRO NO LOG
        return new ResponseEntity<>("Erro interno: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


	//Get Imagem
	@GetMapping("/img") //caminho img
	public ResponseEntity<byte[]> getImgBrinquedoByCodigo(@PathVariable int codigo) {
		
		Brinquedo brinquedo = brinquedoService.getBrinquedoByCodigo(codigo);
		byte[] imageFile = brinquedo.getImg();
		
		return ResponseEntity.ok()
					.contentType(MediaType.valueOf(brinquedo.getImgType()))
					.body(imageFile);
	}
}
