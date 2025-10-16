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
public class Estudante extends Pessoa {

    private String curso;
    private int anoIngresso;
    private String statusMatricula;

    public Estudante(int idPessoa, String codigo, String nome, String sexo, LocalDate dataNascimento, String email, String telefone, String curso,
            int anoIngresso, String statusMatricula) {
        super(idPessoa, codigo, nome, sexo, dataNascimento, email, telefone);
        this.curso = curso;
        this.anoIngresso = anoIngresso;
        this.statusMatricula = statusMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public String getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(String statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    @Override
    public void setCodigo(String codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCodigo'");
    }

}
