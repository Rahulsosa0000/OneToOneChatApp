import { Component, OnInit, OnDestroy } from '@angular/core';
import { WebSocketService } from './service/websocket.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { IMessage } from '@stomp/stompjs';

@Component({
  selector: 'app-root',
  imports: [FormsModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  username: string = '';
  recipient: string = '';
  messageContent: string = '';
  messages: any[] = [];

  isChatStarted: boolean = false;

  constructor(private chatService: WebSocketService) {}

  initChat() {
    // Check if the username is valid
    if (this.username.trim().length < 2) {
      alert('Username must be at least 2 characters long.');
      return;
    }
    this.isChatStarted = true;
  
    // Subscribe to the sender's own messages
    this.chatService.subscribeToMessages(this.username, (message: IMessage) => {
      const body = JSON.parse(message.body);
      this.messages.push(body);
    });
  
    // Subscribe to the recipient's messages after sending the message
    if (this.recipient) {
      this.chatService.subscribeToMessages(this.recipient, (message: IMessage) => {
        const body = JSON.parse(message.body);
        this.messages.push(body);
      });
    }
  }
  

  // Send message method
  sendMessage() {
    if (this.messageContent.trim() && this.recipient.trim()) {
      const chatMessage = {
        from: this.username,
        to: this.recipient,
        content: this.messageContent,
        timestamp: new Date().getTime()
      };
  
      // Log the message for debugging
      console.log("Sending Message: ", chatMessage);
  
      // Optional: Display the sent message locally (echo)
      this.messages.push(chatMessage);
  
      // Send the message to the server via WebSocket
      this.chatService.sendMessage(chatMessage);
  
      // Clear the message input
      this.messageContent = '';
    }
  }
  
}