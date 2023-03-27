package africa.semicolon.ofofo.data.models;


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
//@AllArgsConstructor

@Document
public class Post {
    private String title;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id", nullable=false)
    @Id
    private String id;
    private LocalDateTime creationTime = LocalDateTime.now();
    private String body;
//    @OneToMany
//    @JoinColumn(name = "comment_id")
    @DBRef
    private List<Comment> comments = new ArrayList<>();
}

