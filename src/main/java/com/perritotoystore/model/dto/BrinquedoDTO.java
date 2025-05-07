package com.perritotoystore.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

public class BrinquedoDTO {
        private int codigo;
        private String descricao;
        private String categoria;
        private double valor;

        private byte[] imagemBase64;

        public BrinquedoDTO(int codigo, String descricao, String categoria, double valor, byte[] imagemBase64) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.imagemBase64 = imagemBase64;
    }

    // Getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public byte[] getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(byte[] imagemBase64) {
        this.imagemBase64 = imagemBase64;
}
}
    