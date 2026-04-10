package org.judy.service.Comment;

import org.judy.dto.Comment.CommentRequest;
import org.judy.dto.Comment.CommentResponse;

public interface CommentService {

    public CommentResponse createComment(CommentRequest request);

    public CommentResponse updateComment(Long commentId, CommentRequest request);

    public void deleteComment(Long commentId);

    public CommentResponse getCommentInfo(Long commentId);

}
