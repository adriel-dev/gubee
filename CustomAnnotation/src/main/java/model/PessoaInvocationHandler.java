package model;

import annotation.Transactional;
import exception.AnnotationNotPresent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PessoaInvocationHandler implements InvocationHandler {

    private final Object obj;

    public PessoaInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.isAnnotationPresent(Transactional.class)){
            System.out.printf("Iniciando execução do método %s\n", method.getName());
            Object resultado = method.invoke(obj);
            System.out.printf("Finalizando execução do método %s com sucesso\n", method.getName());
            return resultado;
        }
        throw new AnnotationNotPresent();
    }

}