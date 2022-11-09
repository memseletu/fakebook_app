package com.betterworldbook.fakebook.repository;

import com.betterworldbook.fakebook.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query(value = "select * from book where name like CONCAT('%', :query, '%') ",nativeQuery = true)
    Iterable<Book> searchForBookByName(String query);

}
