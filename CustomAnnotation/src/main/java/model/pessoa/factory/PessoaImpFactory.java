package model.pessoa.factory;

import model.pessoa.Pessoa;
import model.pessoa.PessoaImp;

public class PessoaImpFactory implements PessoaFactory {

    @Override
    public Pessoa criarPessoa() {
        return new PessoaImp();
    }

}