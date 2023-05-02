package africa.semicolon.ofofo.data.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Post {
    @Id
    private String id;
    @NotNull(message = "Name can not be null")
    private String title;
    private String body;
    private LocalDateTime creationTime = LocalDateTime.now();
    @DBRef
    private List<Comment> comments = new ArrayList<>();
}

