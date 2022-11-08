package com.betterworldbook.fakebook.repository;

import com.betterworldbook.fakebook.model.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Books, Long> {
    @Query(value = "select * from books where name like %?%1",nativeQuery = true)
    public Iterable<Books> book( String searchBook);

}
