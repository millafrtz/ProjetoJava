package br.edu.up.modelos;

import java.io.Serializable;

public class Treino implements Serializable {
    private String nome;
    private String descricao;

    public Treino(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "br.edu.up.modelos.Treino [nome=" + nome + "]";
    }
}