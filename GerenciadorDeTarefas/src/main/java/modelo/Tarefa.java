package modelo;

public class Tarefa {
    public int id;
    public String descricao;

    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Descricao: " + descricao;
    }
}