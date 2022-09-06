package application.acoplamento.dip;

import application.acoplamento.NotaFiscal;

public interface AcaoAposGerarNota {

    void executa(NotaFiscal nf);

}