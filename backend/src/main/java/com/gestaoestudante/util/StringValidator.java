package com.gestaoestudante.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gestaoestudante.model.domain.Estudante;
import com.gestaoestudante.model.domain.Pessoa;

public class StringValidator {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String NomeValidator(Pessoa pessoa) throws IOException {
        boolean valid = false;
        String nome = null;
        String tipoPessoa = null;
        if (pessoa instanceof Estudante) {
            tipoPessoa = "estuante";
        } else {
            tipoPessoa = "docente";
        }

        do {
            System.out.println("Introduza o nome do " + tipoPessoa + ":");
            nome = br.readLine();
            if (nome.isBlank()) {
                System.out.println("O nome do " + tipoPessoa + " não pode ser nulo!");
            } else if (nome.length() < 3 || nome.length() > 100) {
                System.out.println("O nome do " + tipoPessoa + " é inválido!");
            } else if (nome.matches(".*\\d.*")) {
                System.out.println("O nome do " + tipoPessoa + " é inválido!");
            } else {
                valid = true;
            }
        } while (valid);

        return nome;

    }
}
