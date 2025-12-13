/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.controller;

import com.gestaoestudante.exceptions.EstudanteNaoEncontradoException;
import com.gestaoestudante.model.Entidades.Estudante;
import com.gestaoestudante.model.Entidades.enums.CursoEnum;
import com.gestaoestudante.model.Entidades.enums.StatusEnum;
import com.gestaoestudante.service.EstudanteService;
import com.gestaoestudante.service.PessoaService;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import com.gestaoestudante.validator.PessoaValidator;
import java.util.Arrays;

/**
 *
 * @author Muzime
 */
public class EstudanteConsoleController extends PessoaConsoleController<Estudante> {
    
    private final EstudanteService estudanteService;
    private final String UPDATE_SUCESSO = "atualizado com sucesso!";
    
    public EstudanteConsoleController(PessoaService pessoaService, EstudanteService estudanteService, Scanner sc) {
        super(pessoaService, sc);
        this.estudanteService = estudanteService;
        
    }
    
    public void registarEstudante() {
        Estudante estudante = null;
        try {
            String nome = lerNome();
            String sexo = lerSexo();
            LocalDate dataNascimento = lerDataNascimento();
            String email = lerEmail();
            String telefone = lerTelefone();
            int anoIngresso = lerAnoIngresso();
            CursoEnum curso = lerCurso();
            String status = lerStatus();
            estudante = estudanteService.criarEstudante(nome, sexo, dataNascimento, email,
                    telefone, anoIngresso, curso, status);
            
            System.out.println("Estudante registado com sucesso!");
            mostrarEstudante(estudante.getCodigo());
        } catch (Exception e) {
            System.out.println("Erro! " + e.getMessage());
        }
        
    }
    
    public void mostrarEstudante(String codEstudante) {
        try {
            Estudante estudante = estudanteService.buscarEstudante(codEstudante);
            System.out.println("Dados do estudante: "
                    + "\nCodigo: " + estudante.getCodigo()
                    + "\nNome: " + estudante.getNome()
                    + "\nSexo: " + estudante.getSexo()
                    + "\nData de Nascimento: " + estudante.getDataNascimento()
                    + "\nEmail: " + estudante.getEmail()
                    + "\nTelefone: " + estudante.getTelefone()
                    + "\nCurso(s): " + estudante.getCursos()
                    + "\nStatus: " + estudante.getStatusMatricula());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void removerEstudante(String codEstudante) {
        try {
            estudanteService.buscarEstudante(codEstudante);
            estudanteService.removerEstudante(codEstudante);
            System.out.println("Removido com sucesso!");
        } catch (EstudanteNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void actualizaNomeEstudante(String codEstudante) {
        try {
            String nome = lerNome();
            pessoaService.validarNome(nome);
            estudanteService.actualizaNomeEstudante(codEstudante, nome);
            System.out.println("Nome " + UPDATE_SUCESSO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void actualizaEmailEstudante(String codEstudante) {
        try {
            String email = lerEmail();
            pessoaService.validarEmail(email);
            estudanteService.actualizaEmailEstudante(codEstudante, email);
            System.out.println("Email " + UPDATE_SUCESSO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void actualizaTelefoneEstudante(String codEstudante) {
        try {
            String telefone = lerTelefone();
            pessoaService.validarTelefone(telefone);;
            estudanteService.actualizaTelefoneEstudante(codEstudante, telefone);
            System.out.println("Telefone " + UPDATE_SUCESSO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void actualizaStatusEstudante(String codEstudante) {
        try {
            String status = lerStatus();;
            estudanteService.validarStatus(status);
            estudanteService.actualizaStatusEstudante(codEstudante, status);
            System.out.println("Status " + UPDATE_SUCESSO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void menuAtualizacao(String codEstudante) {
        System.out.println("---Menu de actualizacao do estudante ---\n");
        System.out.println("----Dados actuais do estudante----");
        
        int opc = 0;
        do {
            try {
                System.out.println("Selecione a opcao: ");
                System.out.println("""
                           1. Actualizar nome
                           2. Actualizar email
                           3. Atualizar telefone
                           4. Actualizar status
                           0. Sair
                           >""");
                opc = Integer.parseInt(sc.nextLine());
                
                switch (opc) {
                    case 1 ->
                        actualizaNomeEstudante(codEstudante);
                    case 2 ->
                        actualizaEmailEstudante(codEstudante);
                    case 3 ->
                        actualizaTelefoneEstudante(codEstudante);
                    case 4 ->
                        actualizaStatusEstudante(codEstudante);
                    case 0 ->
                        System.out.println("Saindo ...");
                    
                    default ->
                        System.out.println("Opcao invalida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: entrada invalida!");
            }
        } while (opc != 0);
        menuEstudante();
    }
    
    public void menuEstudante() {
        int opc = 0;
        do {
            try {
                System.out.println("-----BEM VINDO AO MENU ESTUDANTE-----");
                System.out.print("""
                           1. Registar estudante
                           2. Mostrar estudande
                           3. Atualizar estudante
                           4. Remover estudante
                           0. Sair
                           >""");
                opc = Integer.parseInt(sc.nextLine());
                switch (opc) {
                    case 0 ->
                        System.out.println("Saindo...");
                    
                    case 1 ->
                        registarEstudante();
                    case 2 ->
                        mostrarEstudante(lerCodigoEstudante());
                    case 3 ->
                        menuAtualizacao(lerCodigoEstudante());
                    case 4 ->
                        removerEstudante(lerCodigoEstudante());
                    default ->
                        System.out.println("Opcao Invalida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: entrada invalida!");
                menuEstudante();
            }
        } while (opc != 0);
    }
    
    public String lerCodigoEstudante() {
        String codigoEstudante = null;
        while (true) {
            try {
                System.out.println("Codigo de estudante: ");
                codigoEstudante = sc.nextLine();
                estudanteService.validarCodigoEstudante(codigoEstudante);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return codigoEstudante;
    }
    
    public int lerAnoIngresso() {
        int anoIngresso = 0;
        while (true) {
            try {
                System.out.println("Ano de ingresso: ");
                anoIngresso = Integer.parseInt(sc.nextLine());
                estudanteService.validarAnoIngresso(anoIngresso);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
        return anoIngresso;
    }
    
    public String lerStatus() {
        String status = null;
        while (true) {
            try {
                System.out.println("Status" + Arrays.toString(StatusEnum.values()) + ":");
                status = sc.nextLine();
                estudanteService.validarStatus(status);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return status;
    }
    
    public CursoEnum lerCurso() {
        CursoEnum curso = null;
        while (true) {
            try {
                System.out.println("Selecione o curso:");
                for (CursoEnum c : CursoEnum.values()) {
                    System.out.println(c.getIndice() + ". " + c.nameTwo());
                }
                int indice = Integer.parseInt(sc.nextLine());
                curso = estudanteService.parseCurso(indice);
                estudanteService.validarCurso(curso);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return curso;
        
    }
    
}
