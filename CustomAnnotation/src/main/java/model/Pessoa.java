package model;

import annotation.Transactional;

public interface Pessoa {

    @Transactional
    boolean salvaNoBanco();

}