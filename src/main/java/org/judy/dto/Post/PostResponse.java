package org.judy.dto.Post;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 생성
public class PostResponse {

    @NotNull
    private String title;

    @NotNull
    private Long content;

    @NotNull
    private Long authorName;

}
