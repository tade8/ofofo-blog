package africa.semicolon.ofofo.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CreatePostRequest {
    @NotNull
    private String title;
    private String body;
    private String id;
    private LocalDateTime creationTime;
}
