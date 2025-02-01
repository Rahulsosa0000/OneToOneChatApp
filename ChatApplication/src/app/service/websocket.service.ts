// src/app/chat.service.ts
import { Injectable } from '@angular/core';
import SockJS from 'sockjs-client';
import { Client, IMessage } from '@stomp/stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
  private client: Client;
  private connected: boolean = false;

  constructor() {
    this.client = new Client({
      // Connect using SockJS
      webSocketFactory: () => new SockJS('http://localhost:8080/chat'),
      reconnectDelay: 5000,  // optional: auto-reconnect every 5 seconds
      debug: (str) => {
        console.log(str);
      }
    });

    this.client.onConnect = () => {
      console.log('Connected to WebSocket');
      this.connected = true;
    };

    this.client.activate();
  }

  // Subscribe to private messages for a given username
  public subscribeToMessages(username: string, callback: (message: IMessage) => void) {
    // The destination is /user/{username}/queue/messages
    return this.client.subscribe(`/user/${username}/queue/messages`, callback);
  }

  // Send a message via the /app/chat endpoint
  public sendMessage(message: any) {
    if (this.connected) {
      this.client.publish({
        destination: '/app/chat',
        body: JSON.stringify(message)
      });
    } else {
      console.error('WebSocket connection not established');
    }
  }

  


  
}
