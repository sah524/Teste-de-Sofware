package app;

import modelo.Tarefa;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class GerenciadorTarefas {
    static Scanner scanner = new Scanner(System.in);
    static List<Tarefa> tarefas = new ArrayList<>();
    static int contadorId = 1;

    public static void main(String[] args) {
        boolean sair = false;

        System.out.println("=======================================");
        System.out.println(" Bem-vindo ao seu Gerenciador de Tarefas ");
        System.out.println("=======================================");

        while (!sair) {
            System.out.println("\nMenu:");
            System.out.println("---------------------------------------");
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Tarefa");
            System.out.println("4. Remover Tarefa");
            System.out.println("5. Buscar Tarefa");
            System.out.println("6. Sair");
            System.out.println("---------------------------------------");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criar();
                case 2 -> listar();
                case 3 -> atualizar();
                case 4 -> remover();
                case 5 -> buscar();
                case 6 -> sair = true; // apenas muda flag para sair do loop
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("\nSaindo do programa... Até logo!");
        System.out.println("=======================================");
    }

    static void criar() {
        System.out.print("Descrição da tarefa: ");
        String descricao = scanner.nextLine();
        tarefas.add(new Tarefa(contadorId++, descricao));
        System.out.println(" Tarefa criada com sucesso.");
    }

    static void listar() {
        if (tarefas.isEmpty()) {
            System.out.println(" Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("? Lista de Tarefas:");
            tarefas.forEach(System.out::println);
        }
    }

    static void atualizar() {
        System.out.print("ID da tarefa para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Tarefa t : tarefas) {
            if (t.id == id) {
                System.out.print("Nova descrição: ");
                t.descricao = scanner.nextLine();
                System.out.println("🔁 Tarefa atualizada.");
                return;
            }
        }
        System.out.println("❌ Tarefa não encontrada.");
    }

    static void remover() {
        System.out.print("ID da tarefa para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean removida = tarefas.removeIf(t -> t.id == id);
        if (removida) {
            System.out.println("Tarefa removida.");
        } else {
            System.out.println("❌ Tarefa não encontrada.");
        }
    }

    static void buscar() {
        System.out.print("Palavra-chave para busca: ");
        String termo = scanner.nextLine().toLowerCase();
        List<Tarefa> resultados = tarefas.stream()
               .filter(t -> t.descricao.toLowerCase().contains(termo))
               .toList();

        if (resultados.isEmpty()) {
            System.out.println("🔍 Nenhuma tarefa encontrada com esse termo.");
        } else {
            System.out.println("🔍 Tarefas encontradas:");
            resultados.forEach(System.out::println);
        }
    }
}
