package com.desafio.banco.dominio.servico;

import com.desafio.banco.dominio.entidade.Conta;
import com.desafio.banco.dominio.repositorio.ContaRepositorio;

public class TransferenciaServico {

    private final ContaRepositorio contaRepositorio;

    public TransferenciaServico(ContaRepositorio contaRepositorio) {
        this.contaRepositorio = contaRepositorio;
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
        if (contaOrigem.getSaldo() >= valor && valor > 0) {
            contaOrigem.sacar(valor);
            contaDestino.depositar(valor);
            contaRepositorio.salvar(contaOrigem);
            contaRepositorio.salvar(contaDestino);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente ou valor de transferência inválido");
        }
    }
}