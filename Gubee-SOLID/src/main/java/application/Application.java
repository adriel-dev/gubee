package application;

import application.coesao.coeso.CalculadoraDeSalario;
import application.coesao.Cargo;
import application.coesao.Funcionario;

public class Application {

    public static void main(String[] args) {

        Funcionario f = new Funcionario(Cargo.DESENVOLVEDOR, 3000.0);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();

        System.out.println(calc.calcula(f));

    }

}