package org.judy.service.Comment;

import lombok.RequiredArgsConstructor;
import org.judy.dto.Comment.CommentRequest;
import org.judy.dto.Comment.CommentResponse;
import org.judy.entity.Comment.Comment;
import org.judy.repository.Author.AuthorRepository;
import org.judy.repository.Comment.CommentRepository;
import org.judy.repository.Post.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    @Override
    public CommentResponse createComment(CommentRequest request) {
        Comment newComment = commentRepository.save(new Comment(
                null,
                request.getContent(),
                (long) 0,
                postRepository.getReferenceById(request.getPostId()),
                authorRepository.getReferenceById(request.getAuthorId())
        ));
        return new CommentResponse(newComment.getContent(), newComment.getAuthor().getAuthorName());
    }

    @Transactional
    @Override
    public CommentResponse updateComment(Long commentId, CommentRequest request) {
        Comment updateComment = findCommentById(commentId);
        updateComment.update(request);
        return new CommentResponse(updateComment.getContent(), updateComment.getAuthor().getAuthorName());
    }

    @Transactional
    @Override
    public void deleteComment(Long commentId) {
        Comment deleteComment = findCommentById(commentId);
        commentRepository.delete(deleteComment);
    }

    @Transactional(readOnly = true)
    @Override
    public CommentResponse getCommentInfo(Long commentId) {
        Comment commentInfo = findCommentById(commentId);
        return new CommentResponse(commentInfo.getContent(), commentInfo.getAuthor().getAuthorName());
    }

    private Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 댓글 없음"));
    }
}
