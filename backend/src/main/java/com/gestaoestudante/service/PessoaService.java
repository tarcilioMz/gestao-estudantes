package com.gestaoestudante.service;

import com.gestaoestudante.util.IdGenerator;
import com.gestaoestudante.validator.PessoaValidator;
import java.time.DateTimeException;

import java.time.LocalDate;

public class PessoaService implements IdGenerator {

    private static long idPessoaCounter = 1;
    private final PessoaValidator pessoaValidator;

    public PessoaService(PessoaValidator pessoaValidator) {
        this.pessoaValidator = pessoaValidator;

    }

    public void validarNome(String nome) {
        if (!pessoaValidator.isNomeValido(nome)) {
            throw new IllegalArgumentException("Nome invalido");
        }
    }

    public void validarDataNascimento(LocalDate dataNascimento) {
        if (!pessoaValidator.isDataNascimentoValida(dataNascimento)) {
            throw new IllegalArgumentException("Menor de idade!");
        }
    }
    
    public void validarEmail(String email){
        if(!pessoaValidator.isEmailValido(email)){
            throw new IllegalArgumentException("Email invalido!");
        }
    }
    
    public void validarTelefone(String telefone){
        if(!pessoaValidator.isTelefoneValido(telefone)){
            throw new IllegalArgumentException("Telefone invalido");
        }
    }
    public void validarSexo(String sexo){
        if(!pessoaValidator.isSexoValido(sexo)){
            throw new IllegalArgumentException("Sexo invalido");
        }
    }
    
    public LocalDate parseDataNascimento(String dataUser) {
        String[] partes = dataUser.split("-");
               LocalDate dataNascimento = LocalDate.of(Integer.parseInt(partes[0]),
                        Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
        return dataNascimento;
                
    }

    @Override
    public long gerarID() {
        long idGenerated = idPessoaCounter;
        idPessoaCounter++;
        return idGenerated;
    }
}
