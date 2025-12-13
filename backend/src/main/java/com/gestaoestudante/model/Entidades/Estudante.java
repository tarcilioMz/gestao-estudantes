/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.model.Entidades;

import com.gestaoestudante.model.Entidades.enums.CursoEnum;
import java.time.LocalDate;
import com.gestaoestudante.model.Entidades.enums.SexoEnum;

/**
 *
 * @author Muzime
 */
public class Estudante extends Pessoa {

    private CursoEnum curso;
    private int anoIngresso;
    private String statusMatricula;

    public Estudante(long idPessoa, String codigo, String nome, SexoEnum sexo, LocalDate dataNascimento, String email, String telefone, CursoEnum curso, String statusMatricula) {
        super(idPessoa, codigo, nome, sexo, dataNascimento, email, telefone);
        this.curso = curso;
        anoIngresso = LocalDate.now().getYear();
        this.statusMatricula = statusMatricula;
    }

    public Estudante(long idPessoa, String codigo, String nome, SexoEnum sexo, LocalDate dataNascimento, String email, int anoIngresso, String telefone, CursoEnum curso, String statusMatricula) {
        super(idPessoa, codigo, nome, sexo, dataNascimento, email, telefone);
        this.curso = curso;
        this.anoIngresso = anoIngresso;
        this.statusMatricula = statusMatricula;
    }

    public String getCursos() {
        return curso.nameTwo();
    }

    public void setCurso(CursoEnum curso) {
        this.curso = curso;
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

    

}
