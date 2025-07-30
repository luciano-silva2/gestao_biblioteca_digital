package br.edu.ifpb.gestaobibliotecadigital.recommendations;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.services.impl.AvaliacaoService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CriterioMediaAutor extends CriterioRecomendacao {

    private AvaliacaoService avaliacaoService;

    public CriterioMediaAutor(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @Override
    public String recomendar(Livro livro) {
        return null;
    }

    public Map<String, List<Livro>> ordenarPorMediaEAutor(List<Livro> livros) {
        return livros.stream()
                .collect(Collectors.groupingBy(
                        Livro::getAutor, 
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                lista -> lista.stream()
                                        .sorted((livro1, livro2) -> {
                                            double media1 = avaliacaoService.calcularMediaAvaliacoes(livro1.getId());
                                            double media2 = avaliacaoService.calcularMediaAvaliacoes(livro2.getId());
                                            return Double.compare(media2, media1); 
                                        })
                                        .collect(Collectors.toList())
                        )
                ));
    }
}
