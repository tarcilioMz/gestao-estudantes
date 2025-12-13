/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.repository;

import com.gestaoestudante.exceptions.EstudanteNaoEncontradoException;
import com.gestaoestudante.exceptions.ListaEstudantesVaziaException;
import com.gestaoestudante.model.Entidades.Estudante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Muzime
 */
public class EstudanteRepositoryInMemory implements EstudanteRepository{

    private final HashMap<String,Estudante> estudantes = new HashMap<>();
    @Override
    public void salvar(Estudante estudante) {
        estudantes.put(estudante.getCodigo(), estudante);
    }

    @Override
    public Estudante buscarPorCodigo(String codigo) {
        if(!estudantes.containsKey(codigo)) throw new EstudanteNaoEncontradoException
        ("Estudante com codigo "+codigo+" nao encontrado!");
        return estudantes.get(codigo);
    }

    @Override
    public List<Estudante> buscarTodos() {
        if(estudantes.isEmpty()) throw new ListaEstudantesVaziaException(
                "Nao existem estudantes registados!");
        List<Estudante> lista = new ArrayList<>(estudantes.values());
        return lista;
    }

    @Override
    public void atualizarEstudante(Estudante estudante) {
        estudantes.replace(estudante.getCodigo(), estudante);
    }

    @Override
    public void apagarEstudante(String codigo) {
        estudantes.remove(codigo);
    }
    
}
