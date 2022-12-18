package africa.semicolon.ofofo.dtos.requests;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private String commenterName;
    private String id;
    private String comment;
}
