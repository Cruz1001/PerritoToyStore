package com.perritotoystore.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perritotoystore.model.entity.Brinquedo;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Integer>{
        List<Brinquedo> findByCategoria(String categoria);

}
