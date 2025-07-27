package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDataBase {
    public Map<String, Integer> categorias = new HashMap<>();
    public Map<String, Integer> usuarios = new HashMap<>();

    void adicionarCategorias(){
        categorias.put("Romance", 5);
        categorias.put("terror", 2);
        categorias.put("comédia",4);
    }
    void adicionarUsuarios(){
        usuarios.put("Joaozinho da Macaxeira", 5);
        usuarios.put("kleber da Mandioca", 2);
        usuarios.put("Fatima da Fenda Funda",4);
    }

    public static List<String> getLivros(){
        return Arrays.asList(
            "Dom Casmurro",
            "1984",
            "O pequeno Príncipe",
            "Harry Potter",
            "Capitães de Areia",
            "O Hobbit"
        );
    }


    public static List<String> livrosMaisEmprestados(){
        return Arrays.asList("Dom Casmurro", "1984", "O pequeno Príncipe", "Harry Potter");
    }

    public static List<String> usuariosMaisAtivos(){
        return Arrays.asList("Joao", "Maria", "Carlos", "Ana");
    }

    public static int livrosEmprestados(){
        return 35;
    }
    
    public static int reservasPendentes(){
        return 7;
    }
}
