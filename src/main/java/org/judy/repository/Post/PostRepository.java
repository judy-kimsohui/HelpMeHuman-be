package org.judy.repository.Post;

import org.judy.entity.Post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(
            value = "select b from Post b join fetch b.author",
            countQuery = "select count(b) from Post b"
    )
    Page<Post> findAllWithAuthor(Pageable pageable);

    List<Post> findByAuthor_Id(Long authorId);
}
