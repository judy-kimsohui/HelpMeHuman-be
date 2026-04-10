package org.judy.entity.Comment;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.judy.dto.Comment.CommentRequest;
import org.judy.entity.Author.Author;
import org.judy.entity.Post.Post;

@Getter
@Entity
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 자동 증가
    private Long id;

    @NotNull
    private String content;

    @Min(0)
    private Long heart;

    // 댓글 게시물
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    // 댓글 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public void update(CommentRequest request) {
        this.content = request.getContent();
    }
}
