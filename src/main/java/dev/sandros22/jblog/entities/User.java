package dev.sandros22.jblog.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private String email;
    private String password;
    private Date birthday;
    private Date lastLogin;
    private Date created;
}
