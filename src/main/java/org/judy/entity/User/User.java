package org.judy.entity.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.judy.dto.User.UserUpdateRequest;
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
    @JsonIgnore
    private List<Post> posts;

    public void update(String userName) {
        this.userName = userName;
    }

}
