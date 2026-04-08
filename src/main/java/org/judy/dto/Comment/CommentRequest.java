package org.judy.dto.Comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 생성
public class CommentRequest {

    @NotBlank
    private String content;

    @NotNull
    private Long postId;

    @NotNull
    private Long authorId;

}
