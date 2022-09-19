package app;

import model.pessoa.factory.AbstractFactoryEnum;
import model.pessoa.factory.PessoaFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("------- EXECUTANDO COM REFLECTION -------");
        var pessoaProxyJava = PessoaFactory.getFactory(AbstractFactoryEnum.PROXY_PATTERN).criarPessoa();
        pessoaProxyJava.salvaNoBanco();
        System.out.println("-----------------------------------------");
        System.out.println("------- EXECUTANDO COM DYNAMIC PROXY -------");
        var pessoaProxyPattern = PessoaFactory.getFactory(AbstractFactoryEnum.PROXY_JAVA).criarPessoa();
        pessoaProxyPattern.salvaNoBanco();
        System.out.println("--------------------------------------------");
    }

}