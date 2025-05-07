package com.perritotoystore.service;


import com.perritotoystore.model.entity.Brinquedo;
import com.perritotoystore.model.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BrinquedoService {
    @Autowired
    private BrinquedoRepository brinquedoRepository;

    public List<Brinquedo> getAllBrinquedos() {
        return brinquedoRepository.findAll();
    }
    public Brinquedo createBrinquedo(Brinquedo brinquedo) {
        return brinquedoRepository.save(brinquedo);
    }
    public Brinquedo getBrinquedoByCodigo(int codigo) {
        Optional<Brinquedo> optionalBrinquedo = brinquedoRepository.findById(codigo);
        return optionalBrinquedo.orElse(null);
    }
    public boolean deleteBrinquedo(int codigo) {
        brinquedoRepository.deleteById(codigo);
        return !brinquedoRepository.existsById(codigo);
    }
    
    //Criar brinquedo imagem
    public Brinquedo createBrinquedoImg(Brinquedo brinquedo, MultipartFile imageFile) throws IOException {
    	brinquedo.setImgType(imageFile.getContentType());
    	brinquedo.setImg(imageFile.getBytes());
    	return brinquedoRepository.save(brinquedo);
    }
    public List<Brinquedo> getBrinquedosPorCategoria(String categoria) {
        return brinquedoRepository.findByListaCategoriaContaining(categoria);
    }
    
    
    
    //Lista categoria
    /*public String[] getListCategoria() {
    	Brinquedo brinquedo = new Brinquedo();
    	String [] listaCategoria = brinquedo.getListaCategoria();
    	return listaCategoria;
    }*/
}
