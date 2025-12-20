package com.gestaoestudante;

import java.io.IOException;
import java.util.Scanner;

import com.gestaoestudante.controller.DocenteConsoleController;
import com.gestaoestudante.controller.EstudanteConsoleController;
import com.gestaoestudante.controller.MenuUserConsoleController;
import com.gestaoestudante.repository.DocenteRepositoryInMemory;
import com.gestaoestudante.repository.EstudanteRepositoryInMemory;
import com.gestaoestudante.service.DocenteService;
import com.gestaoestudante.service.EstudanteService;
import com.gestaoestudante.service.PessoaService;
import com.gestaoestudante.validator.DocenteValidator;
import com.gestaoestudante.validator.EstudanteValidator;
import com.gestaoestudante.validator.PessoaValidator;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PessoaValidator pessoaValidator = new PessoaValidator();
        PessoaService pessoaService = new PessoaService(pessoaValidator);
        EstudanteValidator estudanteValidator = new EstudanteValidator();
        EstudanteRepositoryInMemory repoEstudante = new EstudanteRepositoryInMemory();
        EstudanteService estudanteService = new EstudanteService(pessoaService, estudanteValidator, repoEstudante);
        EstudanteConsoleController estudanteConsoleController = new EstudanteConsoleController(pessoaService, estudanteService, sc);

        DocenteValidator docenteValidator = new DocenteValidator();
        DocenteRepositoryInMemory repoDocente = new DocenteRepositoryInMemory();
        DocenteService docenteService = new DocenteService(docenteValidator, pessoaService, repoDocente);
        DocenteConsoleController docenteConsoleController = new DocenteConsoleController(pessoaService, sc, docenteService);
        MenuUserConsoleController menuUserConsoleController = new MenuUserConsoleController(docenteConsoleController, estudanteConsoleController, sc);
        menuUserConsoleController.menuGeral();
    }
}
