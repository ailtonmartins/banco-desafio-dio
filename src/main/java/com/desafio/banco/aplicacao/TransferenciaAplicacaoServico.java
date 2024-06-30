package com.desafio.banco.aplicacao;

import com.desafio.banco.dominio.entidade.Conta;
import com.desafio.banco.dominio.servico.TransferenciaServico;

public class TransferenciaAplicacaoServico {

    private final TransferenciaServico transferenciaServico;

    public TransferenciaAplicacaoServico(TransferenciaServico transferenciaServico) {
        this.transferenciaServico = transferenciaServico;
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
        transferenciaServico.transferir(contaOrigem, contaDestino, valor);
    }
}
