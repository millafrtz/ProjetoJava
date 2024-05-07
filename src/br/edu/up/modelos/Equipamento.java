package br.edu.up.modelos;

import java.io.Serializable;

public class Equipamento implements Serializable {
    private String nome;
    private int id;

    public Equipamento(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "br.edu.up.Equipamento [nome=" + nome + ", id=" + id + "]";
    }
}
