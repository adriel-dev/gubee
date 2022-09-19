package model.pessoa.factory;

import model.pessoa.Pessoa;
import model.pessoa.proxy.PessoaProxyJava;

public class FactoryPessoaProxyJava implements PessoaFactory {

    @Override
    public Pessoa criarPessoa() {
        return new PessoaProxyJava();
    }

}