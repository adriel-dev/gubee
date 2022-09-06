package application.coesao;

import application.coesao.srp.DezOuVintePorCento;
import application.coesao.srp.QuinzeOuVinteCincoPorCento;
import application.coesao.srp.RegraDeCalculo;

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