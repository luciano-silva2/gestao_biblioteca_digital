package br.edu.ifpb.gestaobibliotecadigital.relatorios1;

public abstract class RelatorioTemplate {
    public final void gerar(Exportador exportador){
        String cabecalho = gerarCabecalho();
        String corpo = gerarCorpo();
        String rodape = gerarRodape();

        String completo = cabecalho + corpo + rodape;
        exportador.exportar(completo);
    }
        protected abstract String gerarCabecalho();
        protected abstract String gerarCorpo();
        protected String gerarRodape(){
            return "\n--- Fim do Relatório ---";
        }


    
}
