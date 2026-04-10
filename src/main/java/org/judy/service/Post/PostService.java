package org.judy.service.Post;

import org.judy.dto.Comment.CommentResponse;
import org.judy.dto.Post.PostRequest;
import org.judy.dto.Post.PostResponse;
import org.judy.entity.Comment.Comment;

import java.util.*;

public interface PostService {

    public PostResponse createPost(PostRequest request);

    public PostResponse updatePost(Long postId, PostRequest request);

    public void deletePost(Long postId);

    public PostResponse getPostInfo(Long postId);

//    public PostResponse getAllPost();

    public List<Comment> getPostComments(Long postId);


}
