/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.model.Entidades;

import com.gestaoestudante.model.Entidades.enums.Cursos;
import java.time.LocalDate;

import com.gestaoestudante.model.Entidades.enums.Sexo;

/**
 *
 * @author Muzime
 */
public class Estudante extends Pessoa {

    private Cursos curso;
    private int anoIngresso;
    private String statusMatricula;

    public Estudante(long idPessoa, String codigo, String nome, Sexo sexo, LocalDate dataNascimento, String email, String telefone, Cursos curso, String statusMatricula) {
        super(idPessoa, codigo, nome, sexo, dataNascimento, email, telefone);
        this.curso = curso;
        anoIngresso = LocalDate.now().getYear();
        this.statusMatricula = statusMatricula;
    }

    public Estudante(long idPessoa, String codigo, String nome, Sexo sexo, LocalDate dataNascimento, String email, int anoIngresso, String telefone, Cursos curso, String statusMatricula) {
        super(idPessoa, codigo, nome, sexo, dataNascimento, email, telefone);
        this.curso = curso;
        this.anoIngresso = anoIngresso;
        this.statusMatricula = statusMatricula;
    }

    public String getCursos() {
        return curso.nameTwo();
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
    public void setDataNascimento(LocalDate dataNascimento) {
        LocalDate limite = LocalDate.of(2009, 1, 1);
        if (!dataNascimento.isAfter(limite)) {
            throw new IllegalArgumentException("Idade inválida");
        }
    }

}
