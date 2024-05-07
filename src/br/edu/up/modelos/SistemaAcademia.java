package br.edu.up.modelos;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaAcademia {
    private List<Aluno> alunos = new ArrayList<>();
    private List<Treino> treinos = new ArrayList<>();
    private List<Equipamento> equipamentos = new ArrayList<>();
    private List<Instrutor> instrutores = new ArrayList<>();
    private FileManager fileManager = new FileManager();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        fileManager.registrarOperacao("br.edu.up.modelos.Aluno adicionado: " + aluno.getNome(), "log_alunos.txt");
    }

    public void adicionarTreino(Treino treino) {
        treinos.add(treino);
        fileManager.registrarOperacao("Treino adicionado: " + treino.getNome(), "log_treinos.txt");
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
        fileManager.registrarOperacao("br.edu.up.modelos.Equipamento adicionado: " + equipamento.getNome(), "log_equipamentos.txt");
    }

    public void adicionarInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
        fileManager.registrarOperacao("br.edu.up.Instrutor adicionado: " + instrutor.getNome(), "log_instrutores.txt");
    }

    public void removerAluno(int id) {
        Aluno aluno = pesquisarAluno(id);
        if (aluno != null) {
            alunos.remove(aluno);
            fileManager.registrarOperacao("br.edu.up.modelos.Aluno removido: " + aluno.getNome(), "log_alunos.txt");
        } else {
            System.out.println("br.edu.up.modelos.Aluno não encontrado.");
        }
    }

    public void removerTreino(String nome) {
        Treino treino = pesquisarTreino(nome);
        if (treino != null) {
            treinos.remove(treino);
            fileManager.registrarOperacao("Treino removido: " + treino.getNome(), "log_treinos.txt");
        } else {
            System.out.println("Treino não encontrado.");
        }
    }

    public void removerEquipamento(int id) {
        Equipamento equipamento = pesquisarEquipamento(id);
        if (equipamento != null) {
            equipamentos.remove(equipamento);
            fileManager.registrarOperacao("br.edu.up.modelos.Equipamento removido: " + equipamento.getNome(), "log_equipamentos.txt");
        } else {
            System.out.println("br.edu.up.modelos.Equipamento não encontrado.");
        }
    }

    public void removerInstrutor(int id) {
        Instrutor instrutor = pesquisarInstrutor(id);
        if (instrutor != null) {
            instrutores.remove(instrutor);
            fileManager.registrarOperacao("br.edu.up.Instrutor removido: " + instrutor.getNome(), "log_instrutores.txt");
        } else {
            System.out.println("br.edu.up.Instrutor não encontrado.");
        }
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }

    public List<Treino> listarTreinos() {
        return new ArrayList<>(treinos);
    }

    public List<Equipamento> listarEquipamentos() {
        return new ArrayList<>(equipamentos);
    }

    public List<Instrutor> listarInstrutores() {
        return new ArrayList<>(instrutores);
    }

    public Aluno pesquisarAluno(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    public Treino pesquisarTreino(String nome) {
        for (Treino treino : treinos) {
            if (treino.getNome().equalsIgnoreCase(nome)) {
                return treino;
            }
        }
        return null;
    }

    public Equipamento pesquisarEquipamento(int id) {
        for (Equipamento equipamento : equipamentos) {
            if (equipamento.getId() == id) {
                return equipamento;
            }
        }
        return null;
    }

    public Instrutor pesquisarInstrutor(int id) {
        for (Instrutor instrutor : instrutores) {
            if (instrutor.getId() == id) {
                return instrutor;
            }
        }
        return null;
    }

    public void agendarTreino(int idAluno, String nomeTreino, Date data, int idInstrutor) {
        Aluno aluno = pesquisarAluno(idAluno);
        Treino treino = pesquisarTreino(nomeTreino);
        Instrutor instrutor = pesquisarInstrutor(idInstrutor);
        if (aluno != null && treino != null && instrutor != null) {
            if (data.after(new Date())) {
                aluno.adicionarTreino(new AgendamentoTreino(aluno, treino, data, instrutor));
                fileManager.registrarOperacao("Treino agendado para o aluno: " + aluno.getNome() + " - " + treino.getNome() + " - " + data + " - br.edu.up.Instrutor: " + instrutor.getNome(), "log_agendamentos.txt");
                System.out.println("Treino agendado com sucesso para o aluno: " + aluno.getNome());
            } else {
                System.out.println("Data inválida. O treino deve ser agendado para o futuro.");
            }
        } else {
            System.out.println("br.edu.up.modelos.Aluno, treino ou instrutor não encontrado.");
        }
    }

    public void reservarEquipamento(int idAluno, int idEquipamento, Date data) {
        Aluno aluno = pesquisarAluno(idAluno);
        Equipamento equipamento = pesquisarEquipamento(idEquipamento);
        if (aluno != null && equipamento != null) {
            aluno.adicionarEquipamento(new AgendamentoEquipamento(aluno, equipamento, data));
            fileManager.registrarOperacao("br.edu.up.modelos.Equipamento reservado para o aluno: " + aluno.getNome() + " - " + equipamento.getNome() + " - " + data, "log_reservas_equipamentos.txt");
            System.out.println("br.edu.up.modelos.Equipamento reservado com sucesso para o aluno: " + aluno.getNome());
        } else {
            System.out.println("br.edu.up.modelos.Aluno ou equipamento não encontrado.");
        }
    }

    public void verificarHistorico(int idAluno) {
        Aluno aluno = pesquisarAluno(idAluno);
        if (aluno != null) {
            System.out.println("Histórico de treinos do aluno " + aluno.getNome() + ":");
            for (AgendamentoTreino treino : aluno.getHistoricoTreinos()) {
                System.out.println(treino);
            }
            System.out.println("Histórico de equipamentos reservados pelo aluno " + aluno.getNome() + ":");
            for (AgendamentoEquipamento equipamento : aluno.getHistoricoEquipamentos()) {
                System.out.println(equipamento);
            }
        } else {
            System.out.println("br.edu.up.modelos.Aluno não encontrado.");
        }
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public void salvarEFechar() {
        // Implementar lógica para salvar os dados e fechar o programa
        // Por exemplo, salvar os dados em arquivos serializados
    }
}
