/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.validator;

import com.gestaoestudante.model.Entidades.enums.GrauEnum;

/**
 *
 * @author Muzime
 */
public class DocenteValidator {

    public boolean isGrauValido(String grau) {
        if (grau == null || grau.isBlank()) {
            return false;
        }
        for (GrauEnum g : GrauEnum.values()) {
            if (g.name().equalsIgnoreCase(grau)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAreaEspecializacaoValida(String areaEspecializacao) {
        if (areaEspecializacao == null || areaEspecializacao.isBlank()) {
            return false;
        }

        return true;
    }
}
