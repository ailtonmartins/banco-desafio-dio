package com.desafio.banco.dominio.entidade;

import lombok.Data;

@Data
public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
}