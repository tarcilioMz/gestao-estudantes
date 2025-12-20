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
    private final String UPDATE_SUCESSO = "atualizado com sucesso!";

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

    public void menuAtualizacaoDocente(String codigoDocente) {
        int opc = 0;
        do {
            try {
                System.out.println("--MENU DE ATUALIZACAO DO DOCENTE");
                System.out.println("""
                               1. Atualizar nome
                               2. Atualizar email
                               3. Atualizar telefone
                               4. Atualizar Grau academico
                               5. Atualizar area de especializacao
                               0. Sair
                               """);
                opc = Integer.parseInt(sc.nextLine());
                switch (opc) {
                    case 1 ->
                        atualizaNomeDocente(codigoDocente);
                    case 2 ->
                        atualizaEmailDocente(codigoDocente);
                    case 3 ->
                        atualizaTelefoneDocente(codigoDocente);
                    case 4 ->
                        atualizaGrauDoDocente(codigoDocente);
                    case 5 ->
                        atualizaAreaEspecializacao(codigoDocente);
                    case 0 ->
                        System.out.println("Saindo...");
                    default ->
                        System.out.println("Opcao invalida");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opc != 0);
    }

    public void menuDocente() {
        int opc = 0;
        do {
            try {
                System.out.println("----BEM VINDO AO MENU DO DOCENTE----");
                System.out.print("""
                                   1. Registar docente
                                   2. Consultar dados do docente
                                   3. Remover docente
                                   4. Atualizar dados do docente
                                   0. Sair
                                   >
                                   """);
                opc = Integer.parseInt(sc.nextLine());
                switch (opc) {
                    case 1 ->
                        registarDocente();
                    case 2 ->
                        mostrarDocente(docenteService.buscarDocente(lerCodigoDocente()));
                    case 3 ->
                        removerDocente(docenteService.buscarDocente(lerCodigoDocente()));
                    case 4 ->
                        menuAtualizacaoDocente(lerCodigoDocente());
                    case 0 ->
                        System.out.println("Saindo...");
                    default ->
                        System.out.println("Opcao invalida!");
                }
            } catch (Exception e) {
                System.out.println("Erro " + e.getMessage());
            }
        } while (opc != 0);
    }

    public void mostrarDocente(Docente docente) {
        System.out.println("Dados do docente"
                + "\nCodigo: " + docente.getCodigo()
                + "\nNome: " + docente.getNome()
                + "\nSexo: " + docente.getSexo()
                + "\nData de nascimento: " + docente.getDataNascimento()
                + "\nTelefone: " + docente.getTelefone()
                + "\nEmail: " + docente.getEmail()
                + "\nGrau: " + docente.getGrau()
                + "\nArea de especializacao: " + docente.getAreaEspecializacao());
    }

    public void removerDocente(Docente docente) {
        try {
            docenteService.apagarDocente(docente);
            System.out.println("Removido com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizaNomeDocente(String codigo) {
        try {
            String nome = lerNome();
            docenteService.atualizaNome(codigo, nome);
            System.out.println("Nome " + UPDATE_SUCESSO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizaEmailDocente(String codigo) {
        try {
            String email = lerEmail();
            docenteService.atualizaEmail(codigo, email);
            System.out.println("Email " + UPDATE_SUCESSO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizaTelefoneDocente(String codigo) {
        try {
            String telefone = lerTelefone();
            docenteService.atualizaTelefone(codigo, telefone);
            System.out.println("Telefone " + UPDATE_SUCESSO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizaGrauDoDocente(String codigo) {
        try {
            String grau = lerGrau();
            docenteService.atualizaGrau(codigo, grau);
            System.out.println("Grau " + UPDATE_SUCESSO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizaAreaEspecializacao(String codigo) {
        try {
            String areaEspecializacao = lerAreaEspecializacao();
            docenteService.atualizaAreaEspecializacao(codigo, areaEspecializacao);
            System.out.println("Grau " + UPDATE_SUCESSO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String lerCodigoDocente() {
        String codigoDocente = null;
        while (true) {
            try {
                System.out.println("Codigo de docente: ");
                codigoDocente = sc.nextLine();
                docenteService.validarCodigoDocente(codigoDocente);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return codigoDocente;
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
