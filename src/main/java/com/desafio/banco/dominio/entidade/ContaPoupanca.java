package com.desafio.banco.dominio.entidade;


public class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO = 0.05; // 5%

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void aplicarRendimento() {
        double rendimento = getSaldo() * TAXA_RENDIMENTO;
        depositar(rendimento);
    }
}