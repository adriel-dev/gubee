package application.coesao;

import application.coesao.coeso.DezOuVintePorCento;
import application.coesao.coeso.QuinzeOuVinteCincoPorCento;
import application.coesao.coeso.RegraDeCalculo;

public enum Cargo {

    DESENVOLVEDOR(new DezOuVintePorCento()),
    DBA(new QuinzeOuVinteCincoPorCento()),
    TESTER(new QuinzeOuVinteCincoPorCento());
    private RegraDeCalculo regra;
    Cargo(RegraDeCalculo regra) {
        this.regra = regra;
    }
    public RegraDeCalculo getRegra() {
        return regra;
    }


}