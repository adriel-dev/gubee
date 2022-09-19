package model.pessoa.proxy;

import app.Main;
import model.pessoa.Pessoa;
import model.pessoa.factory.AbstractFactoryEnum;
import model.pessoa.factory.PessoaFactory;

import java.lang.reflect.Proxy;

public class PessoaProxyJava implements Pessoa {

    private final Pessoa pessoa = PessoaFactory.getFactory(AbstractFactoryEnum.DEFAULT).criarPessoa();

    private final Pessoa pessoaDynamicProxy = (Pessoa) Proxy.newProxyInstance(Main.class.getClassLoader(),
            new Class[]{Pessoa.class},
            new PessoaInvocationHandler(pessoa));


    @Override
    public boolean salvaNoBanco() {
        return pessoaDynamicProxy.salvaNoBanco();
    }

}