package dev.sandros22.jblog.entities;

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
public class Post{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID postID;
	@ManyToOne
	@JoinColumn(nullable = false)
	private User author;
	private String content;
	private Date postDate;
}
