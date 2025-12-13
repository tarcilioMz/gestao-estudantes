/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.validator;

import com.gestaoestudante.model.Entidades.enums.CursoEnum;
import com.gestaoestudante.model.Entidades.enums.StatusEnum;
import java.time.LocalDate;

/**
 *
 * @author Muzime
 */
public class EstudanteValidator {

    public boolean isStatusValido(String status) {
        if (status == null || status.isBlank()) {
            return false;
        }
        for (StatusEnum st : StatusEnum.values()) {
            if (status.trim().equalsIgnoreCase(st.name())) {
                return true;
            }
        }
        return false;
    }

    public boolean isAnoIngressoValido(int anoIngresso) {
        int anoActual = LocalDate.now().getYear();
        if (anoIngresso < 2000) {
            return false;
        }
        return anoIngresso <= anoActual;
    }

    public boolean isCodigoEstudanteValido(String codigoEstudante) {
        if (codigoEstudante == null) {
            return false;
        }
        return codigoEstudante.contains("EST") && (codigoEstudante.length() < 9);
    }

    public boolean isCursoValido(CursoEnum curso) {
        if (curso == null) {
            return false;
        }
        for (CursoEnum c : CursoEnum.values()) {
            if (c == curso) {
                return true;
            }
        }
        return false;
    }
}
