package com.chat.model;

public class ChatMessage {
	private String from;
	private String to;
	private String content;
	private long timestamp;

	// Constructors
	public ChatMessage() {
	}

	public ChatMessage(String from, String to, String content, long timestamp) {
		this.from = from;
		this.to = to;
		this.content = content;
		this.timestamp = timestamp;
	}

	// Getters and setters
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}

//public class ChatMessage {
//
//    private String sender;
//    private String recipient; // New field for one-to-one chat
//    private String content;
//    private MessageType type;
//
//    // Constructors
//    public ChatMessage() {
//    }
//
//    public ChatMessage(String sender, String recipient, String content, MessageType type) {
//        this.sender = sender;
//        this.recipient = recipient;
//        this.content = content;
//        this.type = type;
//    }
//
//    // Getters and Setters
//    public String getSender() {
//        return sender;
//    }
//
//    public void setSender(String sender) {
//        this.sender = sender;
//    }
//
//    public String getRecipient() {
//        return recipient;
//    }
//
//    public void setRecipient(String recipient) {
//        this.recipient = recipient;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public MessageType getType() {
//        return type;
//    }
//
//    public void setType(MessageType type) {
//        this.type = type;
//    }
//
//    // Builder class for ChatMessage
//    public static class Builder {
//        private String sender;
//        private String recipient;
//        private String content;
//        private MessageType type;
//
//        public Builder sender(String sender) {
//            this.sender = sender;
//            return this;
//        }
//
//        public Builder recipient(String recipient) {
//            this.recipient = recipient;
//            return this;
//        }
//
//        public Builder content(String content) {
//            this.content = content;
//            return this;
//        }
//
//        public Builder type(MessageType type) {
//            this.type = type;
//            return this;
//        }
//
//        public ChatMessage build() {
//            return new ChatMessage(sender, recipient, content, type);
//        }
//    }
//
//    // Static method to create a builder
//    public static Builder builder() {
//        return new Builder();
//    }
//
//	
//
//	
//
//	
//}
