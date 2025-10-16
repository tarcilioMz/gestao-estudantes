package com.gestaoestudante.services;

import java.time.LocalDate;

public class EstudanteServices {

    static int contadorEstudante = 1;
    static LocalDate hoje = LocalDate.now();

    public String gerarCodigoEstudante() {
        int nrEstudante = contadorEstudante;
        String codigoEstudante = "EST" + hoje.getYear() + nrEstudante;
        return codigoEstudante;
    }

    // public void registarEstudante() {
    //     Estudante estudante = new Estudante(gerarCodigoEstudante(),, "", null, null, null, "", null);
    // }
}
