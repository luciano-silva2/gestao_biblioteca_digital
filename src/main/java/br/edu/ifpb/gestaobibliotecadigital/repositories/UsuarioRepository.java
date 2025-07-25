package br.edu.ifpb.gestaobibliotecadigital.repositories;

import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;

public class UsuarioRepository extends Repositorio<Usuario> {

    private static UsuarioRepository instance;

    private UsuarioRepository() {
        super("databases/usuarios.dat");
    }

    @Override
    protected String getId(Usuario item) {
        return item.getId().toString();
    }

    public static UsuarioRepository getInstance() {
        if (instance == null) {
            instance = new UsuarioRepository();
        }
        return instance;
    }

    @Override
    protected String getNome() {
        return "Usuário";
    }
    
}
