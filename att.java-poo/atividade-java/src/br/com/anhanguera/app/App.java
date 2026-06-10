package br.com.anhanguera.app;

import br.com.anhanguera.model.Cliente;
import br.com.anhanguera.model.Dono;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Cenário do Dono 1: 'chefe' ---");

        // 1. Criar o primeiro dono e seus clientes
        Dono dono1 = new Dono("chefe", "senha123");
        Cliente cliente1 = new Cliente("clienteA", "senha456");
        Cliente cliente2 = new Cliente("clienteB", "senha789");

        // 2. Fazer login do dono1 e cadastrar seus clientes
        dono1.setLoggedIn(true);
        dono1.cadastrarCliente(cliente1);
        dono1.cadastrarCliente(cliente2);

        // 3. Listar clientes do dono1
        dono1.listarMeusClientes();

        // 4. Dono1 envia notificações
        dono1.enviarNotificacao("Promoção especial para clientes do Chefe!");

        System.out.println("\n\n--- Cenário do Dono 2: 'gerente' ---");

        // 5. Criar o segundo dono e seus clientes
        Dono dono2 = new Dono("gerente", "g3r#nt3");
        Cliente cliente3 = new Cliente("clienteC", "abc@123");
        Cliente cliente4 = new Cliente("clienteD", "def@456");

        // 6. Fazer login do dono2 e cadastrar seus clientes
        dono2.setLoggedIn(true);
        dono2.cadastrarCliente(cliente3);
        dono2.cadastrarCliente(cliente4);

        // 7. Listar clientes do dono2
        dono2.listarMeusClientes();

        // 8. Dono2 envia notificações
        dono2.enviarNotificacao("Novidades da Gerência para você.");

        System.out.println("\n\n--- Verificando Notificações dos Clientes ---");

        // 9. Cada cliente verifica suas próprias notificações
        System.out.println(">> Cliente A (do Chefe) verifica suas mensagens:");
        cliente1.verNotificacoes();

        System.out.println("\n>> Cliente C (do Gerente) verifica suas mensagens:");
        cliente3.verNotificacoes();

        System.out.println("\n>> Cliente B (do Chefe) também vê a mesma mensagem do seu dono:");
        cliente2.verNotificacoes();
    }
}
