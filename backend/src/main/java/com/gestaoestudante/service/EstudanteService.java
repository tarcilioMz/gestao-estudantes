package com.gestaoestudante.service;

import java.time.LocalDate;
import java.util.Arrays;

import com.gestaoestudante.model.Entidades.Estudante;
import com.gestaoestudante.model.Entidades.enums.CursoEnum;
import com.gestaoestudante.model.Entidades.enums.SexoEnum;
import com.gestaoestudante.util.CodeGenerator;
import com.gestaoestudante.validator.EstudanteValidator;

public class EstudanteService implements CodeGenerator {

    static long contadorEstudante = 1;
    private final PessoaService pessoaService;
    private final EstudanteValidator estudanteValidator;

    public EstudanteService(PessoaService pessoaServices, EstudanteValidator estudanteValidator) {
        this.pessoaService = pessoaServices;
        this.estudanteValidator = estudanteValidator;

    }

    public Estudante registarEstudante(String nome, String sexoUser, LocalDate dataNascimento,
            String email, String telefone, int anoDeIngresso, String status) {
        pessoaService.validarNome(nome);
        pessoaService.validarSexo(sexoUser);
        pessoaService.validarDataNascimento(dataNascimento);
        pessoaService.validarEmail(email);
        pessoaService.validarTelefone(telefone);
        validarAnoIngresso(anoDeIngresso);
        validarStatus(status);
        SexoEnum sexo = parseSexo(sexoUser);
        long idPessoa = pessoaService.gerarID();
        String codigoEstudante = gerarCodigoParticular();
        return new Estudante(idPessoa, codigoEstudante, nome, sexo, dataNascimento, email, telefone, CursoEnum.LIC_ENGENHARIA_QUIMICA, status);

    }

    public void validarStatus(String status) {
        if (!estudanteValidator.isStatusValido(status)) {
            throw new IllegalArgumentException("Status de matricula inválido!");
        }
    }

    public void validarAnoIngresso(int anoIngresso) {
        if (!estudanteValidator.isAnoIngressoValido(anoIngresso)) {
            throw new IllegalArgumentException("Ano de ingresso inválido!");
        }
    }

    public SexoEnum parseSexo(String sexo) {
        if (sexo == null || sexo.isBlank()) {
            throw new IllegalArgumentException("Sexo não pode ser vazio.");
        }
        try {
            return SexoEnum.valueOf(sexo.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Sexo inválido!" + "valores válidos: " + Arrays.toString(SexoEnum.values()));
        }

    }

    @Override
    public String gerarCodigoParticular() {
        long nrEstudante = contadorEstudante;
        LocalDate hoje = LocalDate.now();
        String codigoEstudante = "EST" + hoje.getYear() + nrEstudante;
        contadorEstudante++;
        return codigoEstudante;
    }
}
