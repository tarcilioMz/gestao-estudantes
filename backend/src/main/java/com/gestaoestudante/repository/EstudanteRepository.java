/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gestaoestudante.repository;

import com.gestaoestudante.model.Entidades.Estudante;
import java.util.List;

/**
 *
 * @author Muzime
 */
public interface EstudanteRepository {
    void salvar(Estudante estudante);
    Estudante buscarPorCodigo(String codigo);
    List<Estudante> buscarTodos();
    void atualizarEstudante(Estudante estudante);
    void apagarEstudante(String codigo);
}
