/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.validator;

import com.gestaoestudante.model.Entidades.enums.SexoEnum;
import java.time.LocalDate;

/**
 *
 * @author Muzime
 */
public class PessoaValidator {

    public boolean isNomeValido(String nome) {
        return nome != null
                && !nome.isBlank()
                && nome.length() >= 3
                && nome.length() <= 46;
    }

    public boolean isDataNascimentoValida(LocalDate dataNascimento) {
        if (dataNascimento == null) {
            return false;
        }
        LocalDate hoje = LocalDate.now();
        return !(dataNascimento.isAfter(hoje.minusYears(18)));
    }

    public boolean isEmailValido(String email) {
        return !(email == null)
                && (email.contains("@")
                && email.length() >= 6);

    }

    public boolean isTelefoneValido(String telefone) {
        return !(telefone == null)
                && telefone.contains("+258")
                && telefone.length() >= 13;

    }

    public boolean isSexoValido(String sexo) {
        if(sexo==null || sexo.isBlank()) return false;
        for (SexoEnum sexoEnum : SexoEnum.values()) {
            if (sexo.equalsIgnoreCase(sexoEnum.name())) {
                return true;
            }
        }
        return false;
    }
}
