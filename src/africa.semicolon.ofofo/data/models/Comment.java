package africa.semicolon.ofofo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Document
public class Comment {
    private String commenterName;
    private String comment;
    private LocalDateTime commentTime = LocalDateTime.now();
    @Id
    private String id;
}
