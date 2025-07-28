/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifpb.gestaobibliotecadigital.external;

import java.util.HashMap;
import java.util.Map;

public class ExternalBookAPI {
    private Map<String, String> bookData;

    public ExternalBookAPI() {
        bookData = new HashMap<>();
        bookData.put("978-3-16-148410-0", "O Pequeno Príncipe,Antoine de Saint-Exupéry,Infantil");
        bookData.put("978-0-12-345678-9", "Diário de um Banana,Jeff Kinney,Juvenil");
    }

    public String getBookInfo(String isbn) {
        return bookData.getOrDefault(isbn, "Informações não encontradas");
    }
}