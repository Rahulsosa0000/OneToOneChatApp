package com.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.chat.model.ChatMessage;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

//    // One-to-One Chat (Private Messaging)
//    @MessageMapping("/chat.sendMessage")  // client sent msg this url
//    public void sendPrivateMessage(@Payload ChatMessage chatMessage) {
//        String recipient = chatMessage.getRecipient();
//        String sender = chatMessage.getSender(); 
//
//        if (recipient != null && !recipient.isEmpty()) {
//            messagingTemplate.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
//            System.out.println("Message from: " + sender + " to: " + recipient + " | Message: " + chatMessage.getContent());
//
//        } else {
//            System.out.println("Error: Recipient is null. Cannot send message.");
//        }
//    }
    
    // The client sends messages to /app/chat
    @MessageMapping("/chat")
    public void sendMessage(@Payload ChatMessage chatMessage) {
        // Here, we use convertAndSendToUser to send the message to the specific recipient
        messagingTemplate.convertAndSendToUser(
            chatMessage.getTo(),      // destination user name
            "/queue/messages",        // destination within the user's space
            chatMessage
        );
    }

    
    

   
    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/public", chatMessage); // Broadcast the user joining
    }
}
