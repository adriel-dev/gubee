package model;

import annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class PessoaProxy implements Pessoa {

    private final PessoaImp pessoalReal = new PessoaImp("Adriel", "Felix", 22);

    @Override
    public boolean salvaNoBanco() {
        List<Method> metodos = Arrays.asList(pessoalReal.getClass().getMethods());
        Method metodoSalva = metodos.stream()
                .filter(method -> method.getName().equals("salvaNoBanco"))
                .findFirst()
                .orElse(null);
        if (metodoSalva != null) {
            Transactional temAnnotation = metodoSalva.getAnnotation(Transactional.class);
            if (temAnnotation != null) {
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
            }
        }
        return false;
    }
}