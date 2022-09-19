package model.pessoa.factory;

import model.pessoa.Pessoa;
import model.pessoa.proxy.PessoaPatternProxy;

public class FactoryPessoaPatternProxy implements PessoaFactory {

    @Override
    public Pessoa criarPessoa() {
        return new PessoaPatternProxy();
    }

}