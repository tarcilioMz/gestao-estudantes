package com.gestaoestudante;

import java.io.IOException;

import com.gestaoestudante.model.Entidades.Estudante;
import com.gestaoestudante.model.Entidades.enums.Cursos;
import com.gestaoestudante.services.EstudanteServices;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello worldii!");
        EstudanteServices ets =new  EstudanteServices();
        Estudante e = ets.registarEstudante();
        System.out.println(ets.mostrarEstudantes(e));
        
    }
}
