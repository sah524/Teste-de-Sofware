package app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;
//encoding: UTF-8

public class GerenciadorTarefasTest {

    // Guarda entrada e saída originais
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;   // Entrada simulada
    private ByteArrayOutputStream testOut; // Saída capturada

    // Antes do teste: redireciona saída
    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    // Depois do teste: restaura entrada e saída
    @After
    public void restoreSystem() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    // Simula o que o usuário digita
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    // Pega tudo que foi impresso
    private String getOutput() {
        return testOut.toString();
    }

    // Testa criar, listar e sair
    @Test(timeout = 3000)
    public void testCriarListarSair() {
        // Entradas simuladas no programa
        String input = String.join("\n",
                "1",          // Criar tarefa
                "Testar JUnit", // Descrição
                "2",          // Listar tarefas
                "6"           // Sair
        ) + "\n";

        provideInput(input);      // Passa entrada
        GerenciadorTarefas.main(null); // Roda o programa
        String output = getOutput();

        // Verifica se deu certo
        assertTrue(output.contains("Tarefa criada com sucesso"));
        assertTrue(output.contains("Testar JUnit"));
    }
}
