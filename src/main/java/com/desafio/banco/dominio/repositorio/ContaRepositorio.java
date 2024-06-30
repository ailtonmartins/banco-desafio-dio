package com.desafio.banco.dominio.repositorio;

import com.desafio.banco.dominio.entidade.Conta;

import java.util.List;

public interface ContaRepositorio {
    Conta salvar(Conta conta);
    Conta buscarPorId(Long id);
    List<Conta> buscarTodas();
}