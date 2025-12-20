/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.model.Entidades;

import com.gestaoestudante.model.Entidades.enums.GrauEnum;
import java.time.LocalDate;

import com.gestaoestudante.model.Entidades.enums.SexoEnum;

/**
 *
 * @author Muzime
 */
public class Docente extends Pessoa {

    private GrauEnum grau;
    private String areaEspecializacao;

    public Docente(long idPessoa, String codigo, String nome, SexoEnum sexo,
            LocalDate dataNascimento, String email, String telefone, GrauEnum grau, 
            String areaEspecializacao) {
        super(idPessoa, codigo, nome, sexo, dataNascimento, email, telefone);
        this.grau = grau;
        this.areaEspecializacao = areaEspecializacao;

    }

    public GrauEnum getGrau() {
        return grau;
    }

    public String getAreaEspecializacao() {
        return areaEspecializacao;
    }

    public void setGrau(GrauEnum grau) {
        this.grau = grau;
    }

    public void setAreaEspecializacao(String areaEspecializacao) {
        this.areaEspecializacao = areaEspecializacao;
    }

}
