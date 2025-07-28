/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpb.gestaobibliotecadigital.app.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ComentarioFlyweight {
    private static Map<String, String> comentarios = new HashMap<>();

    // Se Comentario ja existe
    public static String getComentario(String texto) {
        if (!comentarios.containsKey(texto)) {
            comentarios.put(texto, texto);
        }
        return comentarios.get(texto);
    }
}