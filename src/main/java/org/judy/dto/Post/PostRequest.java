package org.judy.dto.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 생성
public class PostRequest {

    @NotBlank
    private String title;

    @NotBlank
    private Long content;

    @NotNull
    private Long authorId;

}
