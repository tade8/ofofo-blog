package africa.semicolon.ofofo.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDateTime;
@Getter
@Setter
@ToString
public class CreatePostRequest {
    private String title;
    private String body;
    private Integer id;
    private LocalDateTime creationTime;
}
