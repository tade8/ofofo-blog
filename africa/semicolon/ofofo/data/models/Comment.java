package africa.semicolon.ofofo.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Comment {
    private String commenterName;
    private String id;
    private String comment;
    private LocalDateTime commentTime = LocalDateTime.now();
}
