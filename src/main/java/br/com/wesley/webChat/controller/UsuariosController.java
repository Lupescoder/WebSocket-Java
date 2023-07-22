package br.com.wesley.webChat.controller;

import br.com.wesley.webChat.model.Usuario;
import br.com.wesley.webChat.websocket.MessageWebSocketHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private final MessageWebSocketHandler webSocketHandler;

    public UsuariosController(MessageWebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }
    @GetMapping("mensagem")
    @ResponseBody
    public String mensagemDoUsuario (@RequestParam(name = "id") String id){
        Map<String, Usuario> listaDeUsuarios =  webSocketHandler.getUsuarioList();
        Usuario usuario = listaDeUsuarios.get(id);
        return usuario.getMensagem();
    }

    @GetMapping
    public Usuario dadosDoUsuario (@RequestParam(name = "id") String id){
        Map<String, Usuario> listaDeUsuarios =  webSocketHandler.getUsuarioList();
        Usuario usuario = listaDeUsuarios.get(id);
        return usuario;
    }

    @GetMapping("listar")
    public Map<String, Usuario> listarUsuarios (){
        Map<String, Usuario> listaDeUsuarios =  webSocketHandler.getUsuarioList();
        return listaDeUsuarios;
    }

}
