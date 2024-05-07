package br.edu.up.modelos;


import java.io.Serializable;
import java.util.Date;

public class AgendamentoTreino implements Serializable {
    private Aluno aluno;
    private Treino treino;
    private Date data;
    private Instrutor instrutor;

    public AgendamentoTreino(Aluno aluno, Treino treino, Date data, Instrutor instrutor) {
        this.aluno = aluno;
        this.treino = treino;
        this.data = data;
        this.instrutor = instrutor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Treino getTreino() {
        return treino;
    }

    public Date getData() {
        return data;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    @Override
    public String toString() {
        return "Agendamento de Treino [aluno=" + aluno.getNome() + ", treino=" + treino.getNome() + ", data=" + data + ", instrutor=" + instrutor.getNome() + "]";
    }
}
