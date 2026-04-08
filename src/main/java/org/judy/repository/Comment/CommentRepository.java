package org.judy.repository.Comment;

import org.judy.entity.Comment.Comment;
import org.judy.entity.Post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(
            value = "select b from Comment b join fetch b.post",
            countQuery = "select count(b) from Comment b"
    )
    Page<Comment> findAllWithPost(Pageable pageable);
}
