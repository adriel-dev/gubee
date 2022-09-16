package model.pessoa;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    @Transactional
    public boolean salvaNoBanco() {
        System.out.println("------> Registro salvo! <------");
        System.out.printf("Nome: %s\n", nome);
        System.out.printf("Sobrenome: %s\n", sobrenome);
        System.out.printf("Idade: %d\n", idade);
        return true;
    }

}