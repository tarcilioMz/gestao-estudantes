package com.gestaoestudante.service;

import com.gestaoestudante.util.IdGenerator;
import com.gestaoestudante.validator.PessoaValidator;

import java.time.LocalDate;

public class PessoaService implements IdGenerator {

    private static long idPessoaCounter = 1;
    private final PessoaValidator pessoaValidator;

    public PessoaService(PessoaValidator pessoaValidator) {
        this.pessoaValidator = pessoaValidator;

    }

    public void validarNome(String nome) {
        if (!pessoaValidator.isNomeValido(nome)) {
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    public void validarDataNascimento(LocalDate dataNascimento) {
        if (!pessoaValidator.isDataNascimentoValida(dataNascimento)) {
            throw new IllegalArgumentException("Data de nascimento inválida!");
        }
    }
    
    public void validarEmail(String email){
        if(!pessoaValidator.isEmailValido(email)){
            throw new IllegalArgumentException("Email inválido!");
        }
    }
    
    public void validarTelefone(String telefone){
        if(!pessoaValidator.isTelefoneValido(telefone)){
            throw new IllegalArgumentException("Telefone inválido");
        }
    }
    public void validarSexo(String sexo){
        if(!pessoaValidator.isSexoValido(sexo)){
            throw new IllegalArgumentException("Sexo inválido");
        }
    }

    @Override
    public long gerarID() {
        long idGenerated = idPessoaCounter;
        idPessoaCounter++;
        return idGenerated;
    }
}
