/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.model.domain;

import java.time.LocalDate;

/**
 *
 * @author Muzime
 */
public class Docente extends Pessoa {

    private String grau;
    private String areaEspecializacao;

    Docente(int idPessoa, String codigo, String nome, String sexo,
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
    public void setCodigo(String codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCodigo'");
    }

}
