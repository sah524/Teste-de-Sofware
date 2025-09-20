package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarefaTest {
//testando
    @Test
    public void testToString() {
        Tarefa tarefa = new Tarefa(1, "Estudar para a prova");
        String esperado = "ID: 1 | Descricao: Estudar para a prova";
        assertEquals(esperado, tarefa.toString());
    }
}
