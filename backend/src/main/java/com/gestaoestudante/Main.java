package com.gestaoestudante;

import java.io.IOException;
import java.util.Scanner;

import com.gestaoestudante.controller.DocenteConsoleController;
import com.gestaoestudante.repository.DocenteRepositoryInMemory;
import com.gestaoestudante.service.DocenteService;
import com.gestaoestudante.service.PessoaService;
import com.gestaoestudante.validator.DocenteValidator;
import com.gestaoestudante.validator.PessoaValidator;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PessoaValidator pessoaValidator = new PessoaValidator();
        PessoaService pessoaService = new PessoaService(pessoaValidator);
//        EstudanteValidator estudanteValidator = new EstudanteValidator();
//        EstudanteRepositoryInMemory repo = new EstudanteRepositoryInMemory();
//        EstudanteService estudanteService = new EstudanteService(pessoaService, estudanteValidator, repo);
//        EstudanteConsoleController estudanteConsoleController = new EstudanteConsoleController(pessoaService, estudanteService, sc);
//        estudanteConsoleController.menuEstudante();

        DocenteValidator docenteValidator = new DocenteValidator();
        DocenteRepositoryInMemory repo = new DocenteRepositoryInMemory();
        DocenteService docenteService = new DocenteService(docenteValidator, pessoaService, repo);
        DocenteConsoleController docenteConsoleController = new DocenteConsoleController(pessoaService, sc, docenteService);
        docenteConsoleController.menuDocente();
    }
}
