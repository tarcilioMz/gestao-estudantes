package com.gestaoestudante.util;

import com.gestaoestudante.model.Entidades.enums.Types;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class StringValidator {

    BufferedReader br;
    boolean valid = false;
    boolean primeiraTentativa = true;

    public String validaNome(String pessoa) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String nome = null;
        String tipoPessoa = pessoa;
        if ("Estudante".equalsIgnoreCase(tipoPessoa)) {
            tipoPessoa = "estudante";
        } else {
            tipoPessoa = "docente";
        }

        do {
            if (primeiraTentativa) {
                System.out.println("Introduza o nome do " + tipoPessoa + ":");
                nome = br.readLine();
                primeiraTentativa = false;
            } else {
                System.out.println("\nPor favor, introduza o nome do " + tipoPessoa + " novamente:");
                nome = br.readLine();

            }

            if (nome.isBlank()) {
                System.out.println("O nome do " + tipoPessoa + " não pode ser nulo!");
            } else if (nome.length() < 3 || nome.length() > 100) {
                System.out.println("O nome do " + tipoPessoa + " é inválido!");
            } else if (nome.matches(".*\\d.*")) {
                System.out.println("O nome do " + tipoPessoa + " é inválido!");
            } else {
                valid = true;
            }
        } while (valid == false);
        valid = false;
        primeiraTentativa = true;
        return nome;

    }

    public LocalDate validaDataNascimento(String pessoa) throws IOException {
        LocalDate dataNascimento = null;
        LocalDate hoje = LocalDate.now();
        int anoActual = hoje.getYear();
        
        String ano, mes, dia = null;
        int aux = 0;

        br = new BufferedReader(new InputStreamReader(System.in));
        do {
            if (primeiraTentativa) {
                System.out.println("Insira a data de nascimento do " + pessoa + "");

            } else {
                System.out.println("Data de nascimento não válida!\nPor favor, insira novamente: ");

            }
            System.out.println("Digite o dia:");
            dia = br.readLine();
            System.out.println("Digite o mes:");
            mes = br.readLine();
            System.out.println("Digite o ano:");
            ano = br.readLine();

            if (ano.matches(".*[^0-9].*") || mes.matches(".*[^0-9].*") || dia.matches(".*[^0-9].*")) {
                primeiraTentativa = false;
            } else {

                aux = Integer.parseInt(ano);
                int idade = anoActual - aux;
                if (!((idade >= 17 && idade <= 80))) {
                    primeiraTentativa = false;
                } else {
                    aux = Integer.parseInt(mes);
                    if (!(aux >= 1 && aux <= 12)) {
                        primeiraTentativa = false;
                    } else {
                        aux = Integer.parseInt(dia);
                        if (!(aux >= 1 && aux <= 31)) {
                            primeiraTentativa = false;
                        } else {
                            valid = true;
                        }

                    }

                }
            }

        } while (valid == false);
        primeiraTentativa = true;
        valid = false;
        dataNascimento = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
        return dataNascimento;
    }

    public Object leitor(String msg, Types tipo) {
        String obj = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println(msg);
            obj = br.readLine();
            // e possivel retornar cases atraves de um switch-case
            return switch (tipo) {
                case INT ->
                    Integer.parseInt(obj);
                case LONG ->
                    Long.parseLong(obj);
                case FLOAT ->
                    Float.parseFloat(obj);
                case BOOL ->
                    Boolean.parseBoolean(obj);
                case STRING ->
                    obj;

                default ->
                    throw new AssertionError("Tipo inválido");

            };

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
