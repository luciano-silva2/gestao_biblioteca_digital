package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

import br.edu.ifpb.gestaobibliotecadigital.services.impl.EmprestimoService;

public class RelatorioLivrosEmprestados {
    public void livrosMaisEmprestados(){
        EmprestimoService emprestimoService = new EmprestimoService();
        var livrosMaisEmprestados = emprestimoService.ranking();
        livrosMaisEmprestados.forEach(entry -> {
           System.out.println("Livro: " + entry.getKey().getTitulo() + " - Empréstimos: " + entry.getValue());
       });
    }

    
}
