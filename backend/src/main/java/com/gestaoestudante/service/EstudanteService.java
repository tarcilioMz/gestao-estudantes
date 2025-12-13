package com.gestaoestudante.service;

import java.time.LocalDate;
import java.util.Arrays;

import com.gestaoestudante.model.Entidades.Estudante;
import com.gestaoestudante.model.Entidades.enums.CursoEnum;
import com.gestaoestudante.model.Entidades.enums.SexoEnum;
import com.gestaoestudante.repository.EstudanteRepository;
import com.gestaoestudante.repository.EstudanteRepositoryInMemory;
import com.gestaoestudante.util.CodeGenerator;
import com.gestaoestudante.validator.EstudanteValidator;
import java.util.List;

public class EstudanteService implements CodeGenerator {
    
    static long contadorEstudante = 1;
    private final PessoaService pessoaService;
    private final EstudanteValidator estudanteValidator;
    private final EstudanteRepository repo;
    
    public EstudanteService(PessoaService pessoaServices, EstudanteValidator estudanteValidator,
            EstudanteRepository repo) {
        this.pessoaService = pessoaServices;
        this.estudanteValidator = estudanteValidator;
        this.repo = repo;
        
    }
    
    public Estudante criarEstudante(String nome, String sexoUser, LocalDate dataNascimento,
            String email, String telefone, int anoDeIngresso, CursoEnum curso, String status) {
        pessoaService.validarNome(nome);
        pessoaService.validarSexo(sexoUser);
        pessoaService.validarDataNascimento(dataNascimento);
        pessoaService.validarEmail(email);
        pessoaService.validarTelefone(telefone);
        validarAnoIngresso(anoDeIngresso);
        validarCurso(curso);
        validarStatus(status);
        SexoEnum sexo = parseSexo(sexoUser);
        long idPessoa = pessoaService.gerarID();
        String codigoEstudante = gerarCodigoParticular();
        Estudante estudante = new Estudante(idPessoa, codigoEstudante, nome, sexo, dataNascimento,
                email, telefone, curso, status);
        repo.salvar(estudante);
        return estudante;
        
    }
    
    public Estudante actualizaNomeEstudante(String codigoEstudante, String nome) {
        Estudante estudante = buscarEstudante(codigoEstudante);
        estudante.setNome(nome);
//        estudante.setCurso(curso);
        repo.atualizarEstudante(estudante);
        return estudante;
        
    }
    public Estudante actualizaEmailEstudante(String codigoEstudante, String email){
        Estudante estudante = buscarEstudante(codigoEstudante);
        estudante.setEmail(email);
        repo.atualizarEstudante(estudante);
        return estudante;
    }
    public Estudante actualizaTelefoneEstudante(String codigoEstudante, String telefone){
        Estudante estudante = buscarEstudante(codigoEstudante);
        estudante.setTelefone(telefone);
        repo.atualizarEstudante(estudante);
        return estudante;
    }
    public Estudante actualizaStatusEstudante(String codigoEstudante, String status){
        Estudante estudante = buscarEstudante(codigoEstudante);
        estudante.setStatusMatricula(status);
        repo.atualizarEstudante(estudante);
        return estudante;
    }
    
    public Estudante buscarEstudante(String codigoEstudante) {
        return repo.buscarPorCodigo(codigoEstudante);
  
    }

    public void removerEstudante(String codigoEstudante) {
        repo.apagarEstudante(codigoEstudante);
    }
    
    public List<Estudante> buscaTodos(){
        return repo.buscarTodos();
    }
    
    public void validarStatus(String status) {
        if (!estudanteValidator.isStatusValido(status)) {
            throw new IllegalArgumentException("Status de matricula invalido!");
        }
    }
    
    public void validarAnoIngresso(int anoIngresso) {
        if (!estudanteValidator.isAnoIngressoValido(anoIngresso)) {
            throw new IllegalArgumentException("Ano de ingresso invalido!");
        }
    }
    
    public void validarCurso(CursoEnum curso) {
        if (!estudanteValidator.isCursoValido(curso)) {
            throw new IllegalArgumentException("Curso invalido!");
        }
    }
    
  public void validarCodigoEstudante(String codigoEstudante){
      if(!estudanteValidator.isCodigoEstudanteValido(codigoEstudante)){
          throw new IllegalArgumentException("Codigo de estudante "+codigoEstudante+" invalido!");
      }
  }
    public CursoEnum parseCurso(int indice) {
        for (CursoEnum c : CursoEnum.values()) {
            if (c.getIndice() == indice) {
                return c;
            }
        }
        throw new IllegalArgumentException("Curso nao encontrado!");
        
    }
    
    public SexoEnum parseSexo(String sexo) {
        if (sexo == null || sexo.isBlank()) {
            throw new IllegalArgumentException("Sexo não pode ser vazio.");
        }
        try {
            return SexoEnum.valueOf(sexo.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Sexo invalido!" + "valores validos: " + Arrays.toString(SexoEnum.values()));
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
