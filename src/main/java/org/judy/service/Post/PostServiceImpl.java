package org.judy.service.Post;


import lombok.RequiredArgsConstructor;
import org.judy.dto.Comment.CommentResponse;
import org.judy.dto.Post.PostRequest;
import org.judy.dto.Post.PostResponse;
import org.judy.entity.Comment.Comment;
import org.judy.entity.Post.Post;
import org.judy.repository.Author.AuthorRepository;
import org.judy.repository.Post.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    @Override
    public PostResponse createPost(PostRequest request) {
        Post newPost = postRepository.save(new Post(
                null,
                request.getTitle(),
                request.getContent(),
                (long) 0,
                authorRepository.getReferenceById(request.getAuthorId()),
                new ArrayList<>()
        ));
        return new PostResponse(newPost.getTitle(), newPost.getContent(), newPost.getAuthor().getAuthorName());
    }

    @Transactional
    @Override
    public PostResponse updatePost(Long postId, PostRequest request) {
        Post updatePost = findPostById(postId);
        updatePost.update(request);
        return new PostResponse(updatePost.getTitle(), updatePost.getContent(), updatePost.getAuthor().getAuthorName());
    }

    @Transactional
    @Override
    public void deletePost(Long postId) {
        Post deletePost = findPostById(postId);
        postRepository.delete(deletePost);
    }

    @Transactional(readOnly = true)
    @Override
    public PostResponse getPostInfo(Long postId) {
        Post postInfo = findPostById(postId);
        return new PostResponse(postInfo.getTitle(), postInfo.getContent(), postInfo.getAuthor().getAuthorName());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getPostComments(Long postId) {
        return findPostById(postId).getComments();
    }

    private Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 게시글 없음"));
    }
}
