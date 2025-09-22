package modelo;

public class Tarefa {
    private int id;            // Identificador da tarefa
    private String descricao;  // Texto da tarefa

    // Construtor pra criar a tarefa com id e descrição
    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Getter para o ID da tarefa
    public int getId() {
        return id;
    }

    // Getter para a descrição da tarefa
    public String getDescricao() {
        return descricao;
    }

    // Setter para atualizar a descrição da tarefa
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Quando imprimir, mostra id e descrição formatadinhos
    @Override
    public String toString() {
        return "ID: " + id + " | Descricao: " + descricao;
    }
}
