package app;

import model.pessoa.*;
import model.pessoa.factory.PessoaFactory;
import model.pessoa.factory.PessoaImpFactory;
import model.pessoa.factory.PessoaProxyFactory;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        PessoaFactory impFactory = new PessoaImpFactory();
        PessoaImp pessoa = (PessoaImp) impFactory.criarPessoa();
        pessoa.setNome("Adriel");
        pessoa.setSobrenome("Felix");
        pessoa.setIdade(22);

        PessoaFactory proxyFactory = new PessoaProxyFactory(pessoa);

        System.out.println("------- EXECUTANDO COM REFLECTION -------");
        Pessoa pessoaProxy = proxyFactory.criarPessoa();
        var result = pessoaProxy.salvaNoBanco();
        System.out.println(result);
        System.out.println("-----------------------------------------");

        System.out.println("------- EXECUTANDO COM DYNAMIC PROXY -------");
        Pessoa pessoaDynamicProxy = (Pessoa) Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{Pessoa.class},
                new PessoaInvocationHandler(pessoa));
        var secondResult = pessoaDynamicProxy.salvaNoBanco();
        System.out.println(secondResult);
        System.out.println("--------------------------------------------");
    }

}