package org.judy.dto.Post;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor
public class PostResponse {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String authorName;

}
