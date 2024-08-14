package dev.sandros22.jblog.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID postID;
    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "userID")
    private User author;
    @Column(nullable = false)
    private String content;
    private Date postDate;
}
