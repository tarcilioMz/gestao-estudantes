/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.validator;

import com.gestaoestudante.model.Entidades.Estudante;
import com.gestaoestudante.model.Entidades.Pessoa;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Muzime
 */
public class PessoasValidator {
    
    public boolean isNomeValido(String nome) {
        if (nome == null || nome.isBlank() || (nome.length() < 3) || nome.length() > 46) {
            return false;
        }
        return true;
    }

    public boolean isDataNascimentoValida(LocalDate dataNascimento) {
      if(dataNascimento == null){
          return false;
      }
      LocalDate hoje =LocalDate.now();
        return !(dataNascimento.isAfter(hoje.minusYears(18)));
    }

}
