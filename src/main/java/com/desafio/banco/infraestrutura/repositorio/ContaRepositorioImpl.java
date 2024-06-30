package com.desafio.banco.infraestrutura.repositorio;

import com.desafio.banco.dominio.entidade.Conta;
import com.desafio.banco.dominio.repositorio.ContaRepositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContaRepositorioImpl implements ContaRepositorio {

    private final Map<Long, Conta> bancoDeDados = new HashMap<>();
    private Long contadorId = 1L;

    @Override
    public Conta salvar(Conta conta) {
        if ( conta.getId() == null ) {
            conta.setId(contadorId++);
        }
        bancoDeDados.put(conta.getId(), conta);
        return conta;
    }

    @Override
    public Conta buscarPorId(Long id) {
        return bancoDeDados.get(id);
    }

    @Override
    public List<Conta> buscarTodas() {
        return new ArrayList<>(bancoDeDados.values());
    }
}
