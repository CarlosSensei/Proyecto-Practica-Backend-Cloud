package com.ccsw.tutorialauthor.author;

import com.ccsw.tutorialauthor.author.model.Author;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// @author ccsw

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Método para recuperar un listado paginado de {@link Author} @param pageable pageable @return {@link Page} de {@link Author}
    Page<Author> findAll(@NonNull Pageable pageable);

}
