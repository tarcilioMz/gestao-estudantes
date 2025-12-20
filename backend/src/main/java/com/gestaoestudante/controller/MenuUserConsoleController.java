/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.controller;

import java.util.Scanner;

/**
 *
 * @author Muzime
 */
public class MenuUserConsoleController {

    private final DocenteConsoleController docenteconsoleController;
    private final EstudanteConsoleController estudanteConsoleController;
    private final Scanner sc;

    public MenuUserConsoleController(DocenteConsoleController docenteConsoleController,
            EstudanteConsoleController estudanteConsoleController, Scanner sc) {
        this.docenteconsoleController = docenteConsoleController;
        this.estudanteConsoleController = estudanteConsoleController;
        this.sc = sc;
    }

    public void menuGeral() {
        int opc = 0;
        do {
            try {
                System.out.println("---BEM VINDO SISTEMA ACADEMICO----");
                System.out.println("""
                                   1. Menu do estudante
                                   2. Menu do docente
                                   0. Sair
                                   """);
                opc = Integer.parseInt(sc.nextLine());
                switch (opc) {
                    case 1 ->
                        estudanteConsoleController.menuEstudante();
                    case 2 ->
                        docenteconsoleController.menuDocente();
                    case 0 ->
                        System.out.println("Saindo... Obrigado!");
                    default ->
                        System.out.println("Opcao invalida!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (opc != 0);
    }
}
