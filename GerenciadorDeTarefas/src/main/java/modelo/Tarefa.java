package modelo;

public class Tarefa {
    public int id;            // Identificador da tarefa
    public String descricao;  // Texto da tarefa

    // Construtor pra criar a tarefa com id e descrição
    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Quando imprimir, mostra id e descrição formatadinhos
    @Override
    public String toString() {
        return "ID: " + id + " | Descricao: " + descricao;
    }
}
