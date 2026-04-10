package org.judy.entity.Post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.judy.dto.Post.PostRequest;
import org.judy.entity.Author.Author;
import org.judy.entity.Comment.Comment;

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
    @JoinColumn(name = "author_id")
    private Author author;

    // 게시물의 댓글
    @OneToMany(mappedBy = "post")
    @JsonIgnore
    private List<Comment> comments;

    public void update(PostRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
