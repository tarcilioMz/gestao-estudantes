/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoestudante.exceptions;

/**
 *
 * @author Muzime
 */
public class ListaEstudantesVaziaException extends RuntimeException{
    public ListaEstudantesVaziaException(String mensagem){
        super(mensagem);
    }
    
}
