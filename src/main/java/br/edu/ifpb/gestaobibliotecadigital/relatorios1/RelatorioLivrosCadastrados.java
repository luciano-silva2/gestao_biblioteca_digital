package br.edu.ifpb.gestaobibliotecadigital.relatorios1;



public class RelatorioLivrosCadastrados extends RelatorioTemplate {
    @Override
    protected String gerarCabecalho(){
        return "Relatório de livros Cadastrados\n\n";
    }

    @Override 
    protected String gerarCorpo(){
        StringBuilder corpo = new StringBuilder();
        LivroIterator iterator = new LivroIterator(FakeDataBase.getLivros());

        int count = 1;

        while(iterator.hasNext()){
            corpo.append(count++).append(".").append(iterator.next()).append("\n");
        }

        return corpo.toString();
    }
}
