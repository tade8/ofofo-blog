package africa.semicolon.ofofo.dtos.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCommentRequest {
    private String commenterName;
    private String id;
    private String comment;
}
