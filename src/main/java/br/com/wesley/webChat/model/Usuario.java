package br.com.wesley.webChat.model;

import org.springframework.web.socket.TextMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {
    private String id;
    private String nome;
    private String mensagem;
    private List<String> listaDeMensagens = new ArrayList<>();

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.listaDeMensagens.add(mensagem);
        this.mensagem = mensagem;
    }

    public List<String> getListaDeMensagens() {
        return listaDeMensagens;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
