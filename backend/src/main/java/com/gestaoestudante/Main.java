package com.gestaoestudante;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.gestaoestudante.controller.EstudanteConsoleController;
import com.gestaoestudante.validator.PessoasValidator;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer stkn = new StringTokenizer("");
        PessoasValidator psv = new PessoasValidator();
        EstudanteConsoleController estConsole = new EstudanteConsoleController(sc, stkn);
        String nome = estConsole.lerNome(sc);
        System.out.println(nome);

    }
}
