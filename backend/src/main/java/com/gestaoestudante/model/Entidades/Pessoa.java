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
public abstract class Pessoa {

    private long idPessoa;
    private String codigo;
    private String nome;
    private SexoEnum sexo;
    LocalDate dataNascimento;
    private String email;
    private String telefone;

    public Pessoa(long idPessoa, String codigo, String nome, SexoEnum sexo, LocalDate dataNascimento, String email, String telefone) {
        this.idPessoa = idPessoa;
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    public long getIdPessoa() {
        return idPessoa;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo.sexoCapitalCase();
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento=dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
