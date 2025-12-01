package com.gestaoestudante.model.Entidades.enums;

public enum Sexo {
    MASCULINO,
    FEMININO,
    OUTRO;

    public String sexoCapitalCase() {
        String valor = name().toLowerCase();
        return valor.substring(0, 1).toUpperCase() + valor.substring(1);
    }
}
