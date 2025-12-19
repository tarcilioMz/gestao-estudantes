/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.controller;

import com.gestaoestudante.model.Entidades.Docente;
import com.gestaoestudante.service.DocenteService;
import com.gestaoestudante.service.PessoaService;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Muzime
 */
public class DocenteConsoleController extends PessoaConsoleController<Docente> {

    private final DocenteService docenteService;

    public DocenteConsoleController(PessoaService pessoaService, Scanner sc,
            DocenteService docenteService) {
        super(pessoaService, sc);
        this.docenteService = docenteService;
    }

    public void registarDocente() {
        Docente docente = null;
        try {
            String nome = lerNome();
            String sexo = lerSexo();
            LocalDate dataNascimento = lerDataNascimento();
            String email = lerEmail();
            String telefone = lerTelefone();
            String grau = lerGrau();
            String areaEspecializacao = lerAreaEspecializacao();
            docente = docenteService.criarDocente(nome, sexo, dataNascimento, email,
                    telefone, areaEspecializacao, grau);
            mostrarDocente(docente);
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public void mostrarDocente(Docente docente){
        System.out.println("Dados do docente"+
                "\nCodigo: "+docente.getCodigo()+
                "\nNome: "+docente.getNome()+
                "\nSexo: "+docente.getSexo()+
                "\nData de nascimento: "+docente.getDataNascimento()+
                "\nTelefone: "+docente.getTelefone()+
                "\nEmail: "+docente.getEmail()+
                "\nGrau: "+docente.getGrau()+
                "\nArea de especializacao: "+docente.getAreaEspecializacao());
    }
    public String lerGrau() {
        String grau = null; 
        while (true) {
            try {
                System.out.println("Grau: ");
                grau = sc.nextLine();
                docenteService.validarGrau(grau);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return grau;
    }

    public String lerAreaEspecializacao() {
        String areaEspecializacao = null;
        while (true) {
            try {
                System.out.println("Area de especializacao: ");
                areaEspecializacao = sc.nextLine();
                docenteService.validarAreaEspecializacao(areaEspecializacao);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return areaEspecializacao;

    }
}
