/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.recommendations;

import br.edu.ifpb.gestaobibliotecadigital.models.emprestimos.Emprestimo;
import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.repositories.EmprestimoRepository;
import java.util.List;
import java.util.UUID;

public class CriterioMaisLidos extends CriterioRecomendacao {
    private EmprestimoRepository emprestimoRepository;

    public CriterioMaisLidos(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @Override
    public String recomendar(Livro livro) {
        int totalEmprestimos = contarEmprestimosPorLivro(livro.getTitulo());
        System.out.println(totalEmprestimos);
        // Quando for realizado 1 ou mais emprestimos
        // Livros mais Lidos
        if (totalEmprestimos >= 1) {
            System.out.println(totalEmprestimos);
            return livro.getTitulo();
        } else if (proximo != null) {
            return proximo.recomendar(livro);
        }
        return null;
    }
    
    public int contarEmprestimosPorLivro(String titulo) {
        List<Emprestimo> emprestimos = emprestimoRepository.getInstance().listar();
        int count = 0;
        
        for(Emprestimo emprestimo : emprestimos){
            //System.out.println(emprestimo);
            if(emprestimo.getLivro().getTitulo().equals(titulo)){
                count++;
            }
        }
        return count;
    }
}
