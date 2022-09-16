package model.pessoa.factory;

import model.pessoa.Pessoa;
import model.pessoa.PessoaImp;
import model.pessoa.PessoaProxy;

public class PessoaProxyFactory implements PessoaFactory {

    private final PessoaImp pessoalReal;

    public PessoaProxyFactory(PessoaImp pessoalReal) {
        this.pessoalReal = pessoalReal;
    }

    @Override
    public Pessoa criarPessoa() {
        return new PessoaProxy(pessoalReal);
    }

}