package com.desafio.banco.dominio.entidade;


public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void aplicarRendimento() {
        // Contas correntes não aplicam rendimento automaticamente
    }
}