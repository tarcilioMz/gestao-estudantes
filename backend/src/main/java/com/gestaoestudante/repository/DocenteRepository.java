/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gestaoestudante.repository;

import com.gestaoestudante.model.Entidades.Docente;
import java.util.List;

/**
 *
 * @author Muzime
 */
public interface DocenteRepository {
    
    void salvar(Docente docente);
    Docente buscarPorCodigo(String codigoDocente);
    List<Docente> listarTodos();
    void apagarDocente(Docente docente);
    void atualizarDocente(Docente docente);
}
