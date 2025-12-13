/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.model.Entidades;

import java.time.LocalDate;

import com.gestaoestudante.model.Entidades.enums.SexoEnum;

/**
 *
 * @author Muzime
 */
public class Docente extends Pessoa {

    private String grau;
    private String areaEspecializacao;

    Docente(int idPessoa, String codigo, String nome, SexoEnum sexo,
            LocalDate dataNascimento, String email, String telefone, String grau, String areaEspecializacao) {
        super(idPessoa, codigo, nome, sexo, dataNascimento, email, telefone);
        this.grau = grau;
        this.areaEspecializacao = areaEspecializacao;

    }

    public String getGrau() {
        return grau;
    }

    public String getAreaEspecializacao() {
        return areaEspecializacao;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public void setAreaEspecializacao(String areaEspecializacao) {
        this.areaEspecializacao = areaEspecializacao;
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        LocalDate limite = LocalDate.of(2007, 1, 1);
        if(!dataNascimento.isAfter(limite)) throw new IllegalArgumentException("Data de Nascimento inválida");
        this.dataNascimento=dataNascimento;
        
         }

}
