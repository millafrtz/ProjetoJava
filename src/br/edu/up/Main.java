package br.edu.up;

import br.edu.up.modelos.*;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        SistemaAcademia academia = new SistemaAcademia();
        academia.adicionarTreino(new Treino("Tríceps e bíceps", "Trabalho focado nos músculos do tríceps e bíceps."));
        academia.adicionarTreino(new Treino("Ombros e trapézio", "Treino voltado para os músculos dos ombros e trapézio."));
        academia.adicionarTreino(new Treino("Treino completo de pernas (todos os grupos musculares)", "Treino abrangente para todos os grupos musculares das pernas."));
        academia.adicionarTreino(new Treino("Costas", "Trabalho específico nos músculos das costas."));
        academia.adicionarTreino(new Treino("Peitoral", "Foco no desenvolvimento dos músculos do peitoral."));

        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Alunos");
            System.out.println("2. Treinos");
            System.out.println("3. Equipamentos");
            System.out.println("4. Instrutores");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    menuAluno(academia, scanner);
                    break;
                case 2:
                    menuTreino(academia, scanner);
                    break;
                case 3:
                    menuEquipamento(academia, scanner);
                    break;
                case 4:
                    menuInstrutor(academia, scanner);
                    break;
                case 5:
                    academia.salvarEFechar();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }

    public static void menuAluno(SistemaAcademia academia, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\nMenu Aluno:");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Remover Aluno");
            System.out.println("3. Listar Alunos");
            System.out.println("4. Pesquisar Aluno");
            System.out.println("5. Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    adicionarAluno(academia, scanner);
                    break;
                case 2:
                    removerAluno(academia, scanner);
                    break;
                case 3:
                    listarAlunos(academia);
                    break;
                case 4:
                    pesquisarAluno(academia, scanner);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }

    public static void adicionarAluno(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ID do aluno: ");
        int id = scanner.nextInt();
        academia.adicionarAluno(new Aluno(nome, id));
    }

    public static void removerAluno(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o ID do aluno que deseja remover: ");
        int id = scanner.nextInt();
        academia.removerAluno(id);
    }

    public static void listarAlunos(SistemaAcademia academia) {
        List<Aluno> alunos = academia.listarAlunos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public static void pesquisarAluno(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o ID do aluno que deseja pesquisar: ");
        int id = scanner.nextInt();
        Aluno aluno = academia.pesquisarAluno(id);
        if (aluno != null) {
            System.out.println("Aluno encontrado: " + aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void menuTreino(SistemaAcademia academia, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\nMenu Treino:");
            System.out.println("1. Adicionar Treino");
            System.out.println("2. Remover Treino");
            System.out.println("3. Listar Treinos");
            System.out.println("4. Pesquisar Treino");
            System.out.println("5. Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarTreino(academia, scanner);
                    break;
                case 2:
                    removerTreino(academia, scanner);
                    break;
                case 3:
                    listarTreinos(academia);
                    break;
                case 4:
                    pesquisarTreino(academia, scanner);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }

    public static void adicionarTreino(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o nome do treino: ");
        String nome = scanner.next();
        System.out.print("Digite a descrição do treino: ");
        String descricao = scanner.next();
        academia.adicionarTreino(new Treino(nome, descricao));
    }

    public static void removerTreino(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o nome do treino que deseja remover: ");
        String nome = scanner.next();
        academia.removerTreino(nome);
    }

    public static void listarTreinos(SistemaAcademia academia) {
        List<Treino> treinos = academia.listarTreinos();
        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino cadastrado.");
        } else {
            System.out.println("Lista de Treinos:");
            for (Treino treino : treinos) {
                System.out.println(treino);
            }
        }
    }

    public static void pesquisarTreino(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o nome do treino que deseja pesquisar: ");
        String nome = scanner.next();
        Treino treino = academia.pesquisarTreino(nome);
        if (treino != null) {
            System.out.println("Treino encontrado: " + treino);
        } else {
            System.out.println("Treino não encontrado.");
        }
    }

    public static void menuEquipamento(SistemaAcademia academia, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\nMenu Equipamento:");
            System.out.println("1. Adicionar Equipamento");
            System.out.println("2. Remover Equipamento");
            System.out.println("3. Listar Equipamentos");
            System.out.println("4. Pesquisar Equipamento");
            System.out.println("5. Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarEquipamento(academia, scanner);
                    break;
                case 2:
                    removerEquipamento(academia, scanner);
                    break;
                case 3:
                    listarEquipamentos(academia);
                    break;
                case 4:
                    pesquisarEquipamento(academia, scanner);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }

    public static void adicionarEquipamento(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o nome do equipamento: ");
        String nome = scanner.next();
        System.out.print("Digite o ID do equipamento: ");
        int id = scanner.nextInt();
        academia.adicionarEquipamento(new Equipamento(nome, id));
    }

    public static void removerEquipamento(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o ID do equipamento que deseja remover: ");
        int id = scanner.nextInt();
        academia.removerEquipamento(id);
    }

    public static void listarEquipamentos(SistemaAcademia academia) {
        List<Equipamento> equipamentos = academia.listarEquipamentos();
        if (equipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento cadastrado.");
        } else {
            System.out.println("Lista de Equipamentos:");
            for (Equipamento equipamento : equipamentos) {
                System.out.println(equipamento);
            }
        }
    }

    public static void pesquisarEquipamento(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o ID do equipamento que deseja pesquisar: ");
        int id = scanner.nextInt();
        Equipamento equipamento = academia.pesquisarEquipamento(id);
        if (equipamento != null) {
            System.out.println("Equipamento encontrado: " + equipamento);
        } else {
            System.out.println("Equipamento não encontrado.");
        }
    }

    public static void menuInstrutor(SistemaAcademia academia, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\nMenu Instrutor:");
            System.out.println("1. Adicionar Instrutor");
            System.out.println("2. Remover Instrutor");
            System.out.println("3. Listar Instrutores");
            System.out.println("4. Pesquisar Instrutor");
            System.out.println("5. Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarInstrutor(academia, scanner);
                    break;
                case 2:
                    removerInstrutor(academia, scanner);
                    break;
                case 3:
                    listarInstrutores(academia);
                    break;
                case 4:
                    pesquisarInstrutor(academia, scanner);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }

    public static void adicionarInstrutor(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o nome do instrutor: ");
        String nome = scanner.next();
        System.out.print("Digite o ID do instrutor: ");
        int id = scanner.nextInt();
        academia.adicionarInstrutor(new Instrutor(nome, id));
    }

    public static void removerInstrutor(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o ID do instrutor que deseja remover: ");
        int id = scanner.nextInt();
        academia.removerInstrutor(id);
    }

    public static void listarInstrutores(SistemaAcademia academia) {
        List<Instrutor> instrutores = academia.listarInstrutores();
        if (instrutores.isEmpty()) {
            System.out.println("Nenhum instrutor cadastrado.");
        } else {
            System.out.println("Lista de Instrutores:");
            for (Instrutor instrutor : instrutores) {
                System.out.println(instrutor);
            }
        }
    }

    public static void pesquisarInstrutor(SistemaAcademia academia, Scanner scanner) {
        System.out.print("Digite o ID do instrutor que deseja pesquisar: ");
        int id = scanner.nextInt();
        Instrutor instrutor = academia.pesquisarInstrutor(id);
        if (instrutor != null) {
            System.out.println("Instrutor encontrado: " + instrutor);
        } else {
            System.out.println("Instrutor não encontrado.");
        }
    }
}