package app;

import model.pessoa.factory.AbstractFactoryEnum;
import model.pessoa.factory.PessoaFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("------- EXECUTANDO COM REFLECTION (Pattern) -------");
        var pessoaProxyPattern = PessoaFactory.getFactory(AbstractFactoryEnum.PROXY_PATTERN).criarPessoa();
        pessoaProxyPattern.salvaNoBanco();
        System.out.println("-----------------------------------------");
        System.out.println("------- EXECUTANDO COM DYNAMIC PROXY (Java) -------");
        var pessoaProxyJava = PessoaFactory.getFactory(AbstractFactoryEnum.PROXY_JAVA).criarPessoa();
        pessoaProxyJava.salvaNoBanco();
        System.out.println("--------------------------------------------");
    }

}