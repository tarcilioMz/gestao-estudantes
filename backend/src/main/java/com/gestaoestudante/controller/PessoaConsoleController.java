/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.controller;

import com.gestaoestudante.model.Entidades.enums.SexoEnum;
import com.gestaoestudante.service.PessoaService;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Muzime
 * @param <T>
 */
public abstract class PessoaConsoleController<T> {

    protected final PessoaService pessoaService;
    protected final Scanner sc;

    public PessoaConsoleController(PessoaService pessoaService, Scanner sc) {
        this.pessoaService = pessoaService;
        this.sc = sc;
        
    }

    public String lerNome() {
        String nome = null;
        while (true) {
            try {
                System.out.println("Nome: ");
                nome = sc.nextLine();
                pessoaService.validarNome(nome);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ", tente novamente!!\n");
            }

        }
        return nome;

    }

    public String lerSexo() {
        String sexo = null;
        while (true) {
            try {
                System.out.println("Sexo "+Arrays.toString(SexoEnum.values())+": ");
                sexo = sc.nextLine();
                pessoaService.validarSexo(sexo);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return sexo;
    }

    public LocalDate lerDataNascimento() {
        LocalDate dataNascimento;
        while (true) {
            try {
                System.out.println("Data de nascimento [YYYY-MM-dd]: ");
                String dataUser = sc.nextLine();
                dataNascimento = pessoaService.parseDataNascimento(dataUser);
                pessoaService.validarDataNascimento(dataNascimento);
                break;
            } catch (IllegalArgumentException|DateTimeException e) {
                if (e instanceof DateTimeException) {
                    System.out.println("Data invalida! Insira novamente\n");
                } else {
                    System.out.println(e.getMessage());
                }
            }

        }
        return dataNascimento;
    }

    public String lerEmail() {
        String email = null;
        while (true) {
            try {
                System.out.println("Email: ");
                email = sc.nextLine();
                pessoaService.validarEmail(email);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return email;
    }

    public String lerTelefone(){
        String telefone= null;
        while(true){
            try{
                System.out.println("Telefone: ");
                telefone=sc.nextLine();
                pessoaService.validarTelefone(telefone);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return telefone;
    }

}
