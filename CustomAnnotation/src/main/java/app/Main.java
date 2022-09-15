package app;

import model.Pessoa;
import model.PessoaDynamicProxy;
import model.PessoaImp;
import model.PessoaProxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        PessoaImp pessoa = new PessoaImp("Adriel", "Felix", 22);

        System.out.println("------- EXECUTANDO COM REFLECTION -------");
        PessoaProxy pessoaProxy = new PessoaProxy(pessoa);
        var result = pessoaProxy.salvaNoBanco();
        System.out.println("-----------------------------------------");
        System.out.println("------- EXECUTANDO COM DYNAMIC PROXY -------");
        Pessoa pessoaDynamicProxy = (Pessoa) Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{Pessoa.class},
                new PessoaDynamicProxy(pessoa));
        pessoaDynamicProxy.salvaNoBanco();
        System.out.println("--------------------------------------------");
    }

}