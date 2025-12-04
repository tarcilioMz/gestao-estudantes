/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import com.gestaoestudante.validator.PessoasValidator;

/**
 *
 * @author Muzime
 */
public class EstudanteConsoleController {

    // private final Scanner sc;
    private final PessoasValidator pessoasValidator;

    public EstudanteConsoleController() {

        this.pessoasValidator = new PessoasValidator();

    }

    public String lerNome(Scanner sc) {
        String nome = null;
        do {
            System.out.println("Nome completo: ");
            nome = sc.nextLine();

            if (!new PessoasValidator().isNomeValido(nome)) {
                System.out.println("Nome inválido!/nTente novamente");
            }
        } while (!new PessoasValidator().isNomeValido(nome));
        return nome;
    }

    public LocalDate lerDataNascimento(Scanner sc) {
        int dd, mm, year = 0;
        String dataCompleta = null;
        LocalDate dataUsuario = null;
        do {
            try {
                System.out.println("Data de Nascimento no formato [dd/MM/YYYY]:");
                dataCompleta = sc.nextLine();
                String[] dataInseridaArray = dataCompleta.split("/");
                dd = Integer.parseInt(dataInseridaArray[0]);
                mm = Integer.parseInt(dataInseridaArray[1]);
                year = Integer.parseInt(dataInseridaArray[2]);
                dataUsuario = LocalDate.of(year, mm, dd);
                if (!new PessoasValidator().isDataNascimentoValida(dataUsuario)) {
                    throw new IllegalArgumentException();
                }
            } catch (DateTimeException | NullPointerException | ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println("Data Inválida!");
                dataUsuario = null;
            }

        } while (dataUsuario == null);
        return dataUsuario;
    }
}
