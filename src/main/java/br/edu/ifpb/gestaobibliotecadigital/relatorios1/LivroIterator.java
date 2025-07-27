package br.edu.ifpb.gestaobibliotecadigital.relatorios1;
import java.util.List;


public class LivroIterator implements BibliotecaIterator<String>{
    private List<String> livros;
    private int index = 0;

    public LivroIterator(List<String> livros){
        this.livros = livros;
    }

    public boolean hasNext(){
        return index < livros.size();
    }

    public String next(){
        return livros.get(index++);
    }

}
