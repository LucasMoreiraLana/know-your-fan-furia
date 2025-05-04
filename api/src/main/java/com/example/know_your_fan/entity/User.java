package com.example.know_your_fan.entity;

import com.mongodb.annotations.Immutable;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String name;
    private String social;
    private String description;
}
