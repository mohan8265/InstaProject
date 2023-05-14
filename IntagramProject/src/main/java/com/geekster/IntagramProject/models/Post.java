package com.geekster.IntagramProject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String createdDate;
    private String updatedDate;
    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
