package model.pessoa;

import annotation.Transactional;
import exception.AnnotationNotPresent;
import exception.MethodNotPresent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PessoaProxy implements Pessoa {

    private final PessoaImp pessoalReal;

    public PessoaProxy(PessoaImp pessoalReal) {
        this.pessoalReal = pessoalReal;
    }

    @Override
    public boolean salvaNoBanco() {
        try {
            Method metodoSalva = pessoalReal.getClass().getMethod("salvaNoBanco");
                if (metodoSalva.isAnnotationPresent(Transactional.class)) {
                    String status;
                    System.out.printf("Iniciando execução do método %s\n", metodoSalva.getName());
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