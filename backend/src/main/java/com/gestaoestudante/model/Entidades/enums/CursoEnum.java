/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.gestaoestudante.model.Entidades.enums;

/**
 *
 * @author Muzime
 */
public enum CursoEnum {
    LIC_ENGENHARIA_INFORMATICA(1), LIC_ENGENHARIA_QUIMICA(2), LIC_ENGENHARIA_ELECTRICA(3), LIC_ENGENHARIA_ELECTRONICA(4);

    private final int indice;

    

    CursoEnum(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }

    public CursoEnum searchByIndice(int indice) {
        for (CursoEnum c : CursoEnum.values()) {
            if (c.getIndice() == indice) {
                return c;
            }
        }
        throw new IllegalArgumentException("Indice invalido");
    }
    
//    public String nameTwo(){
//        return switch(this.name()) {
//            case "LIC_ENGENHARIA_INFORMATICA" ->
//                "Licenciatura em Engenharia Informatica";
//            case "LIC_ENGENHARIA_QUIMICA" ->
//                "Licenciatura em Engenharia Quimica";
//            case "LIC_ENGENHARIA_ELECTRICA" ->
//                "Licenciatura em Engenharia Electrica";
//            case "LIC_ENGENHARIA_ELECTRONICA" ->
//                "Licenciatura em Engenharia Eletronica";
//            default ->
//                throw new IllegalArgumentException("Curso inválido!");
//        };
//
//    }
    
    // VERSAO MAIS REUTILIZAVEL POREM NECESSITA DE FORMATACAO EXTRA
    public String nameTwo(){
        String []partes = name().split("_");
        StringBuilder sb = new StringBuilder();
        for(String str: partes){
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
        
    }
}
