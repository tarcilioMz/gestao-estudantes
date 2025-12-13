package com.gestaoestudante;

import java.io.IOException;
import java.util.Scanner;

import com.gestaoestudante.controller.EstudanteConsoleController;
import com.gestaoestudante.repository.EstudanteRepositoryInMemory;
import com.gestaoestudante.service.EstudanteService;
import com.gestaoestudante.service.PessoaService;
import com.gestaoestudante.validator.EstudanteValidator;
import com.gestaoestudante.validator.PessoaValidator;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PessoaValidator pessoaValidator = new PessoaValidator();
        PessoaService pessoaService = new PessoaService(pessoaValidator);
        EstudanteValidator estudanteValidator = new EstudanteValidator();
        EstudanteRepositoryInMemory repo = new EstudanteRepositoryInMemory();
        EstudanteService estudanteService = new EstudanteService(pessoaService, estudanteValidator, repo);
        EstudanteConsoleController estudanteConsoleController = new EstudanteConsoleController(pessoaService, estudanteService, sc);
        estudanteConsoleController.menuEstudante();
//        for(Estudante e: repo.buscarTodos()){
//            estudanteConsoleController.mostrarEstudante(e);
//        }
    }
}
