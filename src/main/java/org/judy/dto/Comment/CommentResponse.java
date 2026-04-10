package org.judy.dto.Comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor
public class CommentResponse {

    @NotBlank
    private String content;

    @NotBlank
    private String authorName;
}
