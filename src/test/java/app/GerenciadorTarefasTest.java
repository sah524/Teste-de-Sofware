package app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;
//encoding: UTF-8

public class GerenciadorTarefasTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystem() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test(timeout = 3000)
    public void testCriarListarSair() {
        // Simula: Criar tarefa -> descrição -> Listar -> Sair
        String input = String.join("\n",
                "1",                 // Criar
                "Testar JUnit",     // Descrição
                "2",                 // Listar
                "6"                  // Sair
        ) + "\n";

        provideInput(input);
        GerenciadorTarefas.main(null);

        String output = getOutput();
        assertTrue(output.contains("Tarefa criada com sucesso"));
        assertTrue(output.contains("Testar JUnit"));
    }
}
