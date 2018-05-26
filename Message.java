package WN;

import users.User;

import java.time.LocalDateTime;

public class Message {

    private String content;
    private User author;
    private LocalDateTime created;

    public Message(String content, User author, LocalDateTime created) {
        this.content = content;
        this.author = author;
        if (created != null) {
            this.created = created;
        }
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }




    public String getMessage(){
        String userName = (author != null) ? author.getUsername() : "Anonymous";
        return created.toString()+ userName + "" + content;
    }
}
