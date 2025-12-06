package com.gestaoestudante.model.Entidades.enums;

public enum SexoEnum {
    MASCULINO,
    FEMININO,
    OUTRO;

    public String sexoCapitalCase() {
        String valor = name().toLowerCase();
        return valor.substring(0, 1).toUpperCase() + valor.substring(1);
    }
}
