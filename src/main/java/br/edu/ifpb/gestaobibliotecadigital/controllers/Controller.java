package br.edu.ifpb.gestaobibliotecadigital.controllers;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Administrador;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import br.edu.ifpb.gestaobibliotecadigital.session.UserSessionManager;

public abstract class Controller {

    protected final UserSessionManager userSessionManager = UserSessionManager.getInstance();
    protected final Usuario usuarioLogado = userSessionManager.getUsuarioLogado();

    protected void verificaUsuarioLogado() {
        if (usuarioLogado == null) {
            throw new IllegalStateException("Você precisa estar autenticado para continuar");
        }
    }

    protected void verificaAdministrador() {
        if (!isAdmin()) {
            throw new IllegalStateException("Você não tem permissão de administrador para continuar");
        }
    }
    
    protected boolean isAdmin() {
        return usuarioLogado instanceof Administrador;
    }
}
