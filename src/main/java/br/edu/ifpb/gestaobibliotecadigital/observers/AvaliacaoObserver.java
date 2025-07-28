/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.observers;
import br.edu.ifpb.gestaobibliotecadigital.models.avaliacao.Avaliacao;

public interface AvaliacaoObserver {
    void notificarNovaAvaliacao( Avaliacao avaliacao);
}
