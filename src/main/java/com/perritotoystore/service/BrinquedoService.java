package com.perritotoystore.service;


import com.perritotoystore.model.entity.Brinquedo;
import com.perritotoystore.model.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}}
