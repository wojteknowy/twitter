package WN;

import java.time.LocalDateTime;

public class Message {

    private String content;
    private String author;
    private LocalDateTime created;

    public Message(String content, String author, LocalDateTime created) {
        this.content = content;
        this.author = author;
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }




    public String getMessage(){
        return created.toString()+ author + "" + content;
    }
}
