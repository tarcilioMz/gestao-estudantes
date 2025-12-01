package com.gestaoestudante.services;

import java.io.IOException;
import java.time.LocalDate;

import com.gestaoestudante.model.Entidades.Estudante;
import com.gestaoestudante.model.Entidades.enums.Sexo;
import com.gestaoestudante.model.Entidades.enums.Types;
import com.gestaoestudante.model.Entidades.enums.Cursos;
import com.gestaoestudante.util.CodeGenerator;
import com.gestaoestudante.util.StringValidator;

public class EstudanteServices implements CodeGenerator {

    static int contadorEstudante = 1;
    static LocalDate hoje = LocalDate.now();

    StringValidator strv;
    long iDEstudante;
    Types tipo;

    public EstudanteServices() {
        PessoaServices ps = new PessoaServices();
        iDEstudante = ps.gerarID();

    }

    public Estudante registarEstudante() {
        strv = new StringValidator();

        Estudante estudante = null;
        try {
            Cursos cursosArr[] = Cursos.values();
            String nome = (String) strv.leitor("Introduza o nome: ", tipo.STRING);
            Sexo sexo = Sexo.valueOf(((String) strv.leitor("Sexo: ", tipo.STRING)).toUpperCase());
            String telefone = (String) strv.leitor("Nr de telefone: ", tipo.STRING);
            String email = null;
            do {
                email = (String) strv.leitor("Email: ", tipo.STRING);
            } while (!email.contains("@"));

            System.out.println("Escolha o curso: ");
            Cursos.todosCursos();
            int indice = (int) strv.leitor("opc:", tipo.INT);
//            int indice = 1;
            Cursos cursoE = cursosArr[indice-1];

            estudante = new Estudante(iDEstudante, gerarCodigo(), nome,
                     sexo, strv.validaDataNascimento("estudante"), email,
                    telefone, cursoE, "Ativo");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        contadorEstudante++;
        return estudante;

    }

    public String mostrarEstudantes(Estudante estudante) {
        return """
               DADOS DO ESTUDANTE: 
               ID Estudante: """ + estudante.getIdPessoa()
                + "\nCodigo de Estudante: " + estudante.getCodigo()
                + "\nNome: " + estudante.getNome()
                + "\nSexo: " + estudante.getSexo()
                + "\nData de nascimento: " + estudante.getDataNascimento()
                + "\nEmail: " + estudante.getEmail()
                + "\nTelefone: " + estudante.getTelefone()
                + "\nCurso: " + estudante.getCursos()
                + "\nStatus: " + estudante.getStatusMatricula();

    }

    @Override
    public String gerarCodigo() {
        int nrEstudante = contadorEstudante;
        String codigoEstudante = "EST" + hoje.getYear() + nrEstudante;
        return codigoEstudante;
    }
}
