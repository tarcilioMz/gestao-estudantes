/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.service;

import com.gestaoestudante.exceptions.AreaEspecializacaoException;
import com.gestaoestudante.exceptions.GrauInvalidoException;
import com.gestaoestudante.model.Entidades.Docente;
import com.gestaoestudante.util.CodeGenerator;
import com.gestaoestudante.validator.DocenteValidator;

import java.time.LocalDate;

import com.gestaoestudante.model.Entidades.enums.GrauEnum;
import com.gestaoestudante.model.Entidades.enums.SexoEnum;
import com.gestaoestudante.repository.DocenteRepository;

/**
 *
 * @author Muzime
 */
public class DocenteService implements CodeGenerator {

    private final DocenteValidator docenteValidator;
    private final PessoaService pessoaService;
    private final DocenteRepository repo;
    static long contadorDocente = 1;

    public DocenteService(DocenteValidator docenteValidator, PessoaService pessoaService, DocenteRepository repo) {
        this.docenteValidator = docenteValidator;
        this.pessoaService = pessoaService;
        this.repo = repo;
    }

    public Docente criarDocente(String nome, String sexoUser, LocalDate dataNascimento,
            String email, String telefone, String areaEspecializacao, String grauUser) {
        pessoaService.validarNome(nome);
        pessoaService.validarSexo(sexoUser);
        pessoaService.validarDataNascimento(dataNascimento);
        pessoaService.validarEmail(email);
        pessoaService.validarTelefone(telefone);
        validarAreaEspecializacao(areaEspecializacao);
        validarGrau(grauUser);
        long idPessoa = pessoaService.gerarID();
        String codigo = gerarCodigoParticular();
        SexoEnum sexo = pessoaService.parseSexo(sexoUser);
        GrauEnum grau = parseGrauEnum(grauUser);
        Docente docente = new Docente(idPessoa, codigo, nome, sexo, dataNascimento, email, telefone, grau, areaEspecializacao);
        repo.salvar(docente);
        return docente;
    }

    public Docente buscarDocente(String codigoDocente) {
        return repo.buscarPorCodigo(codigoDocente);
    }

    public Docente atualizaNome(String codigoDocente, String nome) {
        Docente docente = repo.buscarPorCodigo(codigoDocente);
        docente.setNome(nome);
        repo.atualizarDocente(docente);
        return docente;
    }

    public Docente atualizaEmail(String codigoDocente, String email) {
        Docente docente = repo.buscarPorCodigo(codigoDocente);
        docente.setEmail(email);
        repo.atualizarDocente(docente);
        return docente;
    }

    public Docente atualizaTelefone(String codigoDocente, String telefone) {
        Docente docente = repo.buscarPorCodigo(codigoDocente);
        docente.setTelefone(telefone);
        repo.atualizarDocente(docente);
        return docente;
    }

    public Docente atualizaGrau(String codigoDocente, String grau) {
        Docente docente = repo.buscarPorCodigo(codigoDocente);
        docente.setGrau(parseGrauEnum(grau));
        repo.atualizarDocente(docente);
        return docente;
    }

    public Docente atualizaAreaEspecializacao(String codigoDocente, String areaEspecializacao) {
        Docente docente = repo.buscarPorCodigo(codigoDocente);
        docente.setAreaEspecializacao(areaEspecializacao);
        repo.atualizarDocente(docente);
        return docente;
    }

    public void apagarDocente(Docente docente) {
        repo.apagarDocente(docente);
    }

    public void validarGrau(String grau) {
        if (!docenteValidator.isGrauValido(grau)) {
            throw new GrauInvalidoException("Grau invalido!");
        }
    }

    public void validarAreaEspecializacao(String areaEspecializacao) {
        if (!docenteValidator.isAreaEspecializacaoValida(areaEspecializacao)) {
            throw new AreaEspecializacaoException("Area de especializacao invalida!");
        }
    }

    public GrauEnum parseGrauEnum(String grauEnum) {
        for (GrauEnum g : GrauEnum.values()) {
            if (g.name().equalsIgnoreCase(grauEnum)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public String gerarCodigoParticular() {
        long nrDocente = contadorDocente;
        contadorDocente++;
        return "DOC" + LocalDate.now().getYear() + nrDocente;

    }

}
