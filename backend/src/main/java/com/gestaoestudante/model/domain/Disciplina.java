/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.model.domain;

/**
 *
 * @author Muzime
 */
public class Disciplina {

    private int idDisciplina;
    private String codDisciplina;
    private String nomeDisciplina;
    private String semestre;
    private String nivel;
    private int creditos;

    public Disciplina(String codDisciplina, String nomeDisciplina, String semestre, String nivel, int creditos) {
        this.codDisciplina = codDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.semestre = semestre;
        this.nivel = nivel;
        this.creditos = creditos;
    }

    public String getCodDisciplina() {
        return codDisciplina;
    }

    public String getnomeDisciplina() {
        return nomeDisciplina;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getNivel() {
        return nivel;
    }

    public int getCreditos() {
        return creditos;
    }

    @Override
    public String toString() {

        return "";

    }

}
