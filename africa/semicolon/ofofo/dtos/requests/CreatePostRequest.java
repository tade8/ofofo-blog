package africa.semicolon.ofofo.dtos.requests;
import africa.semicolon.ofofo.data.models.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDateTime;
@Getter
@Setter
@ToString
public class CreatePostRequest extends Post {
    private String title;
    private String body;
    private String id;
    private LocalDateTime creationTime;
}
