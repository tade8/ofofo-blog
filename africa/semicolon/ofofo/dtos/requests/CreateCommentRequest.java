package africa.semicolon.ofofo.dtos.requests;

import africa.semicolon.ofofo.data.models.Comment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCommentRequest extends Comment {
    private String commenterName;
    private String id;
    private String comment;
}
