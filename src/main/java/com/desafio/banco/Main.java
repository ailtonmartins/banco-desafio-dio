package com.desafio.banco;

import com.desafio.banco.aplicacao.TransferenciaAplicacaoServico;
import com.desafio.banco.dominio.entidade.Cliente;
import com.desafio.banco.dominio.entidade.ContaCorrente;
import com.desafio.banco.dominio.entidade.ContaPoupanca;
import com.desafio.banco.dominio.repositorio.ContaRepositorio;
import com.desafio.banco.dominio.servico.TransferenciaServico;
import com.desafio.banco.infraestrutura.repositorio.ContaRepositorioImpl;

public class Main {
    public static void main(String[] args) {

        String newLine = System.getProperty("line.separator");

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Ailton Martins");
        cliente1.setCpf("000.000.000-00");
        cliente1.setEndereco("Rua Teste, 123456");

        ContaCorrente contaCorrente = new ContaCorrente(cliente1);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente1);

        ContaRepositorio contaRepositorio = new ContaRepositorioImpl();
        TransferenciaServico transferenciaServico = new TransferenciaServico(contaRepositorio);
        TransferenciaAplicacaoServico transferenciaAplicacaoServico = new TransferenciaAplicacaoServico(transferenciaServico);

        contaCorrente.depositar(1000);
        contaCorrente.depositar(500);

        contaPoupanca.depositar(1000);

        contaRepositorio.salvar(contaCorrente);
        contaRepositorio.salvar(contaPoupanca);

        System.out.println("Saldo inicial Conta Corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo inicial Conta Poupança: " + contaPoupanca.getSaldo());

        System.out.println(newLine);
        System.out.println("Saque de 200");
        contaCorrente.sacar(200);

        System.out.println("Aplicado taxa de redimento da conta poupança de 5%");
        contaPoupanca.aplicarRendimento();

        contaRepositorio.salvar(contaCorrente);
        contaRepositorio.salvar(contaPoupanca);

        System.out.println(newLine);
        System.out.println("Saldo após saque e rendimento:");
        System.out.println("Saldo Conta Corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo Conta Poupança: " + contaPoupanca.getSaldo());

        transferenciaAplicacaoServico.transferir(contaCorrente, contaPoupanca, 300);

        System.out.println(newLine);
        System.out.println("Saldo após transferência de 300 da Conta Corrente para Conta Poupança:");
        System.out.println("Saldo Conta Corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo Conta Poupança: " + contaPoupanca.getSaldo());

        System.out.println(newLine);
        System.out.println(cliente1.toString());
    }
}