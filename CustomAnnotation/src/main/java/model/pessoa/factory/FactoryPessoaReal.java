package model.pessoa.factory;

import model.pessoa.Pessoa;
import model.pessoa.PessoaImpl;

public class FactoryPessoaReal implements PessoaFactory {

    @Override
    public Pessoa criarPessoa() {
        return new PessoaImpl("Adriel", "Felix", 22);
    }

}