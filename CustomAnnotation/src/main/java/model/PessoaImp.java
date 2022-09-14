package model;

import annotation.Transactional;

public class PessoaImp implements Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;

    public PessoaImp() {
    }

    public PessoaImp(String nome, String sobrenome, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    @Transactional
    public boolean salvaNoBanco() {
        System.out.println("------> Registro salvo! <------");
        return true;
    }

}