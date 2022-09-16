package model.pessoa;

import annotation.Transactional;

public interface Pessoa {

    @Transactional
    boolean salvaNoBanco();

}