/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gestaoestudante.exceptions.DocenteNaoEncontradoException;
import com.gestaoestudante.exceptions.ListaVaziaException;
import com.gestaoestudante.model.Entidades.Docente;

/**
 *
 * @author Muzime
 */
public class DocenteRepositoryInMemory implements DocenteRepository {

    private final HashMap<String, Docente> docentes = new HashMap<>();

    @Override
    public void salvar(Docente docente) {
        docentes.put(docente.getCodigo(), docente);
    }

    @Override
    public Docente buscarPorCodigo(String codigoDocente) {
        if (!docentes.containsKey(codigoDocente)) {
            throw new DocenteNaoEncontradoException("Docente com codigo " + codigoDocente + " nao encontrado!");
        }
        return docentes.get(codigoDocente);
    }

    @Override
    public List<Docente> listarTodos() {
        if (docentes.isEmpty()) {
            throw new ListaVaziaException(
                    "Nao existem docentes registados");
        }

        return new ArrayList<>(docentes.values());

    }

    @Override
    public void apagarDocente(Docente docente) {
        docentes.remove(docente.getCodigo());
    }

    @Override
    public void atualizarDocente(Docente docente) {
        docentes.replace(docente.getCodigo(), docente);
    }

}
