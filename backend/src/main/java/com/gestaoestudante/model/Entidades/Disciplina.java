/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.model.Entidades;

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

    public Disciplina(int idDisciplina, String codDisciplina, String nomeDisciplina, String semestre, String nivel, int creditos) {
        this.idDisciplina = idDisciplina;
        this.codDisciplina = codDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.semestre = semestre;
        this.nivel = nivel;
        this.creditos = creditos;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }
    

    public String getCodDisciplina() {
        return codDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public void setCodDisciplina(String codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
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

}
