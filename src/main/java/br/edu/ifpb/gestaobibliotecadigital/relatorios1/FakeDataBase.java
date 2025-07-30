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

    public static Map<String, Integer> livrosMaisEmprestados() {
        Map<String, Integer> dados = new HashMap<>();
        dados.put("Dom Casmurro", 32);
        dados.put("1984", 27);
        dados.put("O Pequeno Príncipe", 25);
        dados.put("Harry Potter", 45);
        return dados;
    }

    public static Map<String, Integer> usuariosMaisAtivos() {
        Map<String, Integer> dados = new HashMap<>();
        dados.put("João", 17);
        dados.put("Maria", 23);
        dados.put("Carlos", 19);
        dados.put("Ana", 25);
        dados.put("Larissa", 30);
        return dados;
    }




    public static int livrosEmprestados(){
        return 35;
    }
    
    public static int reservasPendentes(){
        return 7;
    }
}
