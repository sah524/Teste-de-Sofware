package app;

import modelo.Tarefa;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class GerenciadorTarefas {

    // Scanner pra ler o que a pessoa digita
    static Scanner scanner = new Scanner(System.in);

    // Lista que guarda todas as tarefas criadas
    static List<Tarefa> tarefas = new ArrayList<>();

    // Esse contador é só pra dar um ID único pra cada tarefa
    static int contadorId = 1;

    public static void main(String[] args) {
        boolean sair = false;

        System.out.println("=======================================");
        System.out.println(" Bem-vindo ao seu Gerenciador de Tarefas ");
        System.out.println("=======================================");

        while (!sair) {
            mostrarMenu();

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer

                switch (opcao) {
                    case 1 -> criar();
                    case 2 -> listar();
                    case 3 -> atualizar();
                    case 4 -> remover();
                    case 5 -> buscar();
                    case 6 -> sair = true;
                    default -> System.out.println("Opcao invalida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida! Por favor, digite um numero.");
                scanner.nextLine(); // limpa o buffer para evitar loop infinito
            }
        }

        System.out.println("\nSaindo do programa... Ate logo!");
        System.out.println("=======================================");
    }

    // Mostra o menu principal
    static void mostrarMenu() {
        System.out.println("\nMenu:");
        System.out.println("---------------------------------------");
        System.out.println("1. Criar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Atualizar Tarefa");
        System.out.println("4. Remover Tarefa");
        System.out.println("5. Buscar Tarefa");
        System.out.println("6. Sair");
        System.out.println("---------------------------------------");
        System.out.print("Escolha uma opcao: ");
    }

    // Esse método cria uma nova tarefa
    static void criar() {
        System.out.print("Descricao da tarefa: ");
        String descricao = scanner.nextLine();
        tarefas.add(new Tarefa(contadorId++, descricao)); // adiciona na lista
        System.out.println("Tarefa criada com sucesso.");
    }

    // Aqui lista todas as tarefas que foram criadas até agora
    static void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("Lista de Tarefas:");
            tarefas.forEach(System.out::println); // imprime cada uma
        }
    }

    // Atualiza uma tarefa pelo ID
    static void atualizar() {
        System.out.print("ID da tarefa para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Tarefa tarefa = encontrarPorId(id);
        if (tarefa != null) {
            System.out.print("Nova descrição: ");
            tarefa.setDescricao(scanner.nextLine()); // atualiza a descrição
            System.out.println("Tarefa atualizada.");
        } else {
            System.out.println("Tarefa nao encontrada.");
        }
    }

    // Remove uma tarefa com base no ID
    static void remover() {
        System.out.print("ID da tarefa para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removida = tarefas.removeIf(t -> t.getId() == id);
        if (removida) {
            System.out.println("Tarefa removida.");
        } else {
            System.out.println("Tarefa nao encontrada.");
        }
    }

    // Busca tarefas que tenham determinada palavra na descrição
    static void buscar() {
        System.out.print("Palavra-chave para busca: ");
        String termo = scanner.nextLine().toLowerCase();

        List<Tarefa> resultados = tarefas.stream()
            .filter(t -> t.getDescricao().toLowerCase().contains(termo))
            .toList();

        if (resultados.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com esse termo.");
        } else {
            System.out.println("Tarefas encontradas:");
            resultados.forEach(System.out::println); // mostra os resultados
        }
    }

    // Procura uma tarefa pelo ID
    static Tarefa encontrarPorId(int id) {
        return tarefas.stream()
            .filter(t -> t.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
