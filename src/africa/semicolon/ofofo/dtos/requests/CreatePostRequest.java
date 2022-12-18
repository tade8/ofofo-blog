package africa.semicolon.ofofo.dtos.requests;

import africa.semicolon.ofofo.data.models.Post;

import java.time.LocalDateTime;

public class CreatePostRequest extends Post {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String title;
    private String body;
    private String id;
    private LocalDateTime creationTime;
}
