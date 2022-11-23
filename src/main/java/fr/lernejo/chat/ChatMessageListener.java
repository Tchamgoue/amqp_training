package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {

    private final ChatMessageRepository repo;

    public ChatMessageListener(ChatMessageRepository repo) {
        this.repo = repo;
    }
    public void onMessage(String message) {
        //affiche le contenu du message dans la console
        repo.addChatMessage(message);
    }


}
