package br.edu.up.modelos;



import java.io.Serializable;
import java.util.Date;

public class AgendamentoEquipamento implements Serializable {
    private Aluno aluno;
    private Equipamento equipamento;
    private Date data;

    public AgendamentoEquipamento(Aluno aluno, Equipamento equipamento, Date data) {
        this.aluno = aluno;
        this.equipamento = equipamento;
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Reserva de br.edu.up.Equipamento [aluno=" + aluno.getNome() + ", equipamento=" + equipamento.getNome() + ", data=" + data + "]";
    }
}
