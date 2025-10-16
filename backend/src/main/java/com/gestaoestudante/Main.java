package com.gestaoestudante;

import com.gestaoestudante.services.EstudanteServices;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        EstudanteServices estS = new EstudanteServices();
        System.out.println(estS.gerarCodigoEstudante());
    }
}
