package br.com.wesley.webChat.websocket;

import br.com.wesley.webChat.controller.UsuariosController;
import br.com.wesley.webChat.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
@EnableWebSocket
public class MessageWebSocketHandler extends TextWebSocketHandler implements WebSocketConfigurer {
    private static Set<WebSocketSession> sessions = new HashSet<>();
    private Map<String,Usuario> usuarioList = new HashMap<String, Usuario>();
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this, "/ws").setAllowedOrigins("*");
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        Usuario usuario = new Usuario(session.getId(), "Usuario:"+session.getId());
        usuarioList.put(session.getId(),usuario);

        String sessionIdMessage = "sessionId:" + session.getId();
        session.sendMessage(new TextMessage(sessionIdMessage));

        System.out.println("Conexão Nova Estabelicida : " + usuario);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String payload = message.getPayload();
        System.out.println("Mensagem recebida: " + payload);

        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                try {
                    s.sendMessage(message);
                    usuarioList.get(s.getId()).setMensagem(payload);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        usuarioList.remove(session.getId());
        System.out.println("Conexão fechada: " + session.getId());
    }

    public Map<String, Usuario> getUsuarioList() {
        return this.usuarioList;
    }
}
