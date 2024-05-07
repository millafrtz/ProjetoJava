package br.edu.up.modelos;

import java.io.Serializable;

public class Instrutor implements Serializable {
    private String nome;
    private int id;

    public Instrutor(String nome, int id) {
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
        return "br.edu.up.Instrutor [nome=" + nome + ", id=" + id + "]";
    }
}
