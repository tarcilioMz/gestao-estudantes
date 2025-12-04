/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.controller;

import com.gestaoestudante.validator.PessoasValidator;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Muzime
 */
public class EstudanteConsoleController {

    private final Scanner sc;
    private final StringTokenizer stkn;
    private final PessoasValidator pessoasValidator;

    public EstudanteConsoleController(Scanner sc, StringTokenizer stkn) {
        this.sc = sc;
        this.pessoasValidator = new PessoasValidator();
        this.stkn = stkn;

    }

    public String lerNome(Scanner sc) {
        String nome = null;
        do {
            System.out.println("Nome completo: ");
            nome = sc.nextLine();

            if (!new PessoasValidator().isNomeValido(nome)) {
                System.out.println("Nome inválido!/Tente novamente");
            }
        } while (!new PessoasValidator().isNomeValido(nome));
        return nome;
    }

//    public LocalDate lerDataNascimento(Scanner sc, StringTokenizer stkn) {
//        int dd, mm, year = 0;
//        String dataCompleta = null;
//        LocalDate dataUsuario = null;
//        do {
//            System.out.println("Data de Nascimento no formato [dd/MM/YYYY]:");
//            dataCompleta=sc.nextLine();
//            stkn= new StringTokenizer(dataCompleta, "/");
//            dd=Integer.parseInt(stkn.nextToken());
//            mm=Integer.parseInt(stkn.nextToken());
//            year=Integer.parseInt(stkn.nextToken());
//            try{
//                dataUsuario.of(year, mm, dd);
//            }catch(DateTimeException e){
//                System.out.println("Data Inválida!");
//            }
//            
//        }while(!new PessoasValidator().isDataNascimentoValida(LocalDate.of(year, mm, dd)));
//        return  dataUsuario;
//    }
}
