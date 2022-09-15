package model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PessoaDynamicProxy implements InvocationHandler {

    private final Object obj;

    public PessoaDynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("Iniciando execução do método %s\n", method.getName());
        Object resultado = method.invoke(obj);
        System.out.printf("Finalizando execução do método %s com sucesso\n", method.getName());
        return resultado;
    }

}