package model.pessoa.proxy;

import annotation.Transactional;
import exception.AnnotationNotPresent;
import exception.MethodNotPresent;
import model.pessoa.Pessoa;
import model.pessoa.factory.AbstractFactoryEnum;
import model.pessoa.factory.PessoaFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PessoaPatternProxy implements Pessoa {

    private final Pessoa pessoalReal = PessoaFactory.getFactory(AbstractFactoryEnum.DEFAULT).criarPessoa();

    @Override
    public boolean salvaNoBanco() {
        try {
            Method metodoSalva = pessoalReal.getClass().getMethod("salvaNoBanco");
                if (metodoSalva.isAnnotationPresent(Transactional.class)) {
                    String status;
                    System.out.printf("(PatternProxy) Iniciando execução do método %s\n", metodoSalva.getName());
                    try {
                        metodoSalva.invoke(pessoalReal);
                        status = "sucesso";
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.err.println(e.getMessage());
                        status = "erro";
                    }
                    System.out.printf("Finalizando execução do método %s com %s\n", metodoSalva.getName(), status);
                    return true;
                }
                throw new AnnotationNotPresent();
        } catch (NoSuchMethodException e) {
            throw new MethodNotPresent(e.getMessage());
        }
    }
}