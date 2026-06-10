package br.com.anhanguera.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    // Referência para o Dono que cadastrou este cliente
    private Dono donoResponsavel;
    private List<String> notificacoes;

    public Cliente(String username, String password) {
        super(username, password);
        this.notificacoes = new ArrayList<>();
    }

    public Dono getDonoResponsavel() {
        return donoResponsavel;
    }

    public void setDonoResponsavel(Dono dono) {
        this.donoResponsavel = dono;
    }

    public void receberNotificacao(String mensagem) {
        this.notificacoes.add(mensagem);
    }

    public void verNotificacoes() {
        System.out.println("--- Notificações para " + getUsername() + " ---");
        if (notificacoes.isEmpty()) {
            System.out.println("Nenhuma notificação nova.");
        } else {
            for (String notificacao : notificacoes) {
                System.out.println("- " + notificacao);
            }
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + this.getUsername());
        if (this.donoResponsavel != null){
            System.out.println("Dono: " + this.donoResponsavel.getUsername());
        } else {
            System.out.println("Dono: Nenhum");
        }
    }
}