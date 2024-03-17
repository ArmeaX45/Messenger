package fr.armeax.utils;

import java.time.Instant;
import java.util.UUID;

public class Mail {
    private final int id;
    private final UUID sender;
    private final UUID receiver;
    private final String content;
    private final Instant timestamp;
    private final String attachmentdata;

    public Mail(int id, UUID sender, UUID receiver, String content, Instant timestamp, String attachmentdata) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = timestamp;
        this.attachmentdata = attachmentdata;
    }

    public int getId(){
        return id;
    }

    public UUID getSender(){
        return sender;
    }
    public UUID getReceiver(){
        return receiver;
    }

    public String getContent(){
        return content;
    }

    public Instant getTimestamp(){
        return timestamp;
    }

    public String getAttachmentData(){
        return attachmentdata;
    }

}
