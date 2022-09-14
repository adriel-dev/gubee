package app;

import model.PessoaProxy;

public class Main {

    public static void main(String[] args) {

        PessoaProxy pessoaProxy = new PessoaProxy();
        var result = pessoaProxy.salvaNoBanco();

    }

}