package org.judy.dto.Author;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthorSignupRequest {

    @NotBlank
    private String authorName;
}
