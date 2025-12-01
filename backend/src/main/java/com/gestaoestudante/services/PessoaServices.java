package com.gestaoestudante.services;

import com.gestaoestudante.util.IdGenerator;

public class PessoaServices implements IdGenerator {

    private static long idPessoaCounter = 1;

    @Override
    public long gerarID() {
        long idGenerated = idPessoaCounter;
        idPessoaCounter++;
        return idGenerated;
    }
}
