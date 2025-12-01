/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.gestaoestudante.model.Entidades.enums;

/**
 *
 * @author Muzime
 */
public enum Cursos {
    LIC_ENGENHARIA_INFORMATICA(1), LIC_ENGENHARIA_QUIMICA(2), LIC_ENGENHARIA_ELECTRICA(3), LIC_ENGENHARIA_ELECTRONICA(4);

    private final int indice;

    

    Cursos(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }

    public Cursos searchByIndice(int indice) {
        for (Cursos c : Cursos.values()) {
            if (c.getIndice() == indice) {
                return c;
            }
        }
        throw new IllegalArgumentException("Indice invalido");
    }
    
    public String nameTwo(){
        return switch(this.name()) {
            case "LIC_ENGENHARIA_INFORMATICA" ->
                "Licenciatura em Engenharia Informatica";
            case "LIC_ENGENHARIA_QUIMICA" ->
                "Licenciatura em Engenharia Quimica";
            case "LIC_ENGENHARIA_ELECTRICA" ->
                "Licenciatura em Engenharia Electrica";
            case "LIC_ENGENHARIA_ELECTRONICA" ->
                "Licenciatura em Engenharia Eletronica";
            default ->
                throw new IllegalArgumentException("Curso inválido!");
        };
        
    }

    public static void todosCursos() {
        int i = 1;
        for (Cursos c : Cursos.values()) {
            System.out.println(i + ". " + cursoLeg(c));
            i++;
        }
    }

    public static String cursoLeg(Cursos curso) {
        return switch (curso) {
            case LIC_ENGENHARIA_INFORMATICA ->
                "Licenciatura em Engenharia Informatica";
            case LIC_ENGENHARIA_QUIMICA ->
                "Licenciatura em Engenharia Quimica";
            case LIC_ENGENHARIA_ELECTRICA ->
                "Licenciatura em Engenharia Electrica";
            case LIC_ENGENHARIA_ELECTRONICA ->
                "Licenciatura em Engenharia Eletronica";
            default ->
                throw new IllegalArgumentException("Curso inválido!");
        };

    }
}
