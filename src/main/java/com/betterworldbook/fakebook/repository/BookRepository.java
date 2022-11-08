package com.betterworldbook.fakebook.repository;

import com.betterworldbook.fakebook.model.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Books, Long> {
}
