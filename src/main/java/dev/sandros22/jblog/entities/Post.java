package dev.sandros22.jblog.entities;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post{
	private UUID postID;
	private User author;
	private String content;
	private Date postDate;
}
