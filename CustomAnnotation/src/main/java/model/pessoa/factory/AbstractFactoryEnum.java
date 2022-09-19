package model.pessoa.factory;

import model.pessoa.PessoaImpl;

public enum AbstractFactoryEnum {

    PROXY_PATTERN(new FactoryPessoaPatternProxy()),
    PROXY_JAVA(new FactoryPessoaProxyJava()),
    DEFAULT(new FactoryPessoaReal());

    private final PessoaFactory factory;

    AbstractFactoryEnum(PessoaFactory factory) {
        this.factory = factory;
    }

    public PessoaFactory getFactory() {
        return factory;
    }

}