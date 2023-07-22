package br.com.wesley.webChat.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nome;
    private String mensagem;
    private List<String> listaDeMensagensEnviadas = new ArrayList<>();

    private List<String> listaDeMensagensRecebidas = new ArrayList<>();

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.listaDeMensagensEnviadas.add(mensagem);
        this.mensagem = mensagem;
    }

    public List<String> getListaDeMensagensEnviadas() {
        return listaDeMensagensEnviadas;
    }


    public List<String> getListaDeMensagensRecebidas() {
        return listaDeMensagensRecebidas;
    }

    public void setListaDeMensagensRecebidas(String listaDeMensagensRecebidas) {
        this.listaDeMensagensRecebidas.add(listaDeMensagensRecebidas);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
