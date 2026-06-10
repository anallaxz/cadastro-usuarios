package br.com.anhanguera.service;

import br.com.anhanguera.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<Usuario> usuarios;

    public AuthService() {
        usuarios = new ArrayList<>();
    }

    public boolean register(String username, String password) {
        for (Usuario user : usuarios) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }
        usuarios.add(new Usuario(username, password));
        return true;
    }

    public boolean login(String username, String password) {
        for (Usuario user : usuarios) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                user.setLoggedIn(true);
                return true; // Login successful
            }
        }
        return false; // Invalid credentials
    }

    public void logout(String username) {
        for (Usuario user : usuarios) {
            if (user.getUsername().equals(username)) {
                user.setLoggedIn(false);
                break;
            }
        }
    }

}
