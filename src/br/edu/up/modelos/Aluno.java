package br.edu.up.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aluno implements Serializable {
    private String nome;
    private int id;
    private List<AgendamentoTreino> historicoTreinos = new ArrayList<>();
    private List<AgendamentoEquipamento> historicoEquipamentos = new ArrayList<>();

    public Aluno(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public List<AgendamentoTreino> getHistoricoTreinos() {
        return historicoTreinos;
    }

    public List<AgendamentoEquipamento> getHistoricoEquipamentos() {
        return historicoEquipamentos;
    }

    public void adicionarTreino(AgendamentoTreino agendamentoTreino) {
        historicoTreinos.add(agendamentoTreino);
    }

    public void adicionarEquipamento(AgendamentoEquipamento agendamentoEquipamento) {
        historicoEquipamentos.add(agendamentoEquipamento);
    }

    @Override
    public String toString() {
        return "br.edu.up.modelos.Aluno [nome=" + nome + ", id=" + id + "]";
    }
}