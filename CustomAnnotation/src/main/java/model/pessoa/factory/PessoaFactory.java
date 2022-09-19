package model.pessoa.factory;

import model.pessoa.Pessoa;

public interface PessoaFactory {

    Pessoa criarPessoa();

    static PessoaFactory getFactory(AbstractFactoryEnum factoryEnum) {
        return factoryEnum.getFactory();
    }

}