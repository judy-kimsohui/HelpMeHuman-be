package org.judy.repository.Author;

import org.judy.entity.Author.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {
}
