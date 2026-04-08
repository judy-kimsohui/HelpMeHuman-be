package org.judy.entity.Post;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.judy.entity.Comment.Comment;
import org.judy.entity.User.User;

import java.util.*;

@Getter
@Entity
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 자동 증가
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @Min(0)
    private Long heart;

    // 게시물 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    // 게시물의 댓글
    @OneToMany(mappedBy = "post")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Comment> comments;

}
