package org.judy.entity.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.judy.entity.Post.Post;

import java.util.*;

@Getter
@Entity
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 자동 증가
    private Long id;

    @NotNull
    private String userName;

    // 사용자의 글
    @OneToMany(mappedBy = "user")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Post> posts;

}
