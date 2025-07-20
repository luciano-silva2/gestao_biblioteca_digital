/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.models.avaliacao;

import br.edu.ifpb.gestaobibliotecadigital.models.livros.Livro;
import br.edu.ifpb.gestaobibliotecadigital.models.usuarios.Usuario;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author 202312040013
 */
public class Avaliacao implements Serializable{
    private final Livro livro;
    private final Usuario usuario;
    private final double nota;
    private final String comentario;
    private final LocalDateTime dataHora;
    private final UUID id;
        

    public Avaliacao(Livro livro, Usuario usuario, double nota, String comentario, UUID livroId) {
        this.livro = livro;
        this.usuario = usuario;
        this.nota = nota;
        this.comentario = comentario;
        this.dataHora = LocalDateTime.now();
        this.id = livroId;
    }
    

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + livro.getId() + "livro=" + livro.getTitulo() + ", usuario = " + usuario + ", nota=" + nota + ", comentario=" + comentario + ", dataHora=" + dataHora + '}';
    }

    public UUID getId() {
        return id;
    }
    
    
    
    
}
