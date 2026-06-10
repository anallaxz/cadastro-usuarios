package br.com.anhanguera.model;

import java.util.ArrayList;
import java.util.List;

public class Dono extends Usuario {
    private List<Cliente> clientesCadastrados;

    public Dono(String username, String password) {
        super(username, password);
        this.clientesCadastrados = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente novoCliente) {
        if (this.isLoggedIn()) {
            // Vínculo acontece aqui! O Dono diz: "Este cliente é meu"
            novoCliente.setDonoResponsavel(this);

            clientesCadastrados.add(novoCliente);
            System.out.println("Sucesso: Cliente '" + novoCliente.getUsername() + "' cadastrado pelo dono '" + this.getUsername() + "'.");
        } else {
            System.out.println("Erro: O dono '" + this.getUsername() + "' precisa estar logado para cadastrar clientes.");
        }
    }

    public void enviarNotificacao(String mensagem) {
        if (!isLoggedIn()) {
            System.out.println("Erro: O dono precisa estar logado para enviar notificações.");
            return;
        }
        System.out.println("\n" + getUsername() + " enviando a seguinte notificação para seus clientes: '" + mensagem + "'");
        for (Cliente cliente : clientesCadastrados) {
            cliente.receberNotificacao(mensagem);
        }
    }

    public void listarMeusClientes() {
        System.out.println("--- Clientes do Dono: " + this.getUsername() + " ---");
        for (Cliente c : clientesCadastrados) {
            System.out.println("- " + c.getUsername() + " (User: " + c.getUsername() + ")");
        }
    }
}
