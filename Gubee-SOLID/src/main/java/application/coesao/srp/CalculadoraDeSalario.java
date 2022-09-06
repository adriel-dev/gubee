package application.coesao.srp;

import application.coesao.Funcionario;

import static application.coesao.Cargo.*;

public class CalculadoraDeSalario {

    public double calcula(Funcionario funcionario) {

        if (DESENVOLVEDOR.equals(funcionario.getCargo())) {
            return new DezOuVintePorCento().calcula(funcionario);
        }
        if (DBA.equals(funcionario.getCargo()) || TESTER.equals(funcionario.getCargo())) {
            return new QuinzeOuVinteCincoPorCento().calcula(funcionario);
        }
        throw new RuntimeException("funcionario invalido");
    }

}