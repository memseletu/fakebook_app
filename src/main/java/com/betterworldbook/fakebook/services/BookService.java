package com.betterworldbook.fakebook.services;

import com.betterworldbook.fakebook.model.Books;
import com.betterworldbook.fakebook.repository.BookRepository;
import com.betterworldbook.fakebook.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
   private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<?> getBookById ( Long bookId) {
        Books p = bookRepository.findById(bookId).orElse(null);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }


    public Iterable<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public void createBook( Long categoryId, Books books) {
       categoryRepository.findById(categoryId).map(category -> {
           books.setCategory(category);
            return bookRepository.save(books);
        });
    }
    public void updateBooks(Long categoryId, Books books){
        categoryRepository.findById(categoryId).map(category -> {
            books.setCategory(category);
            return bookRepository.save(books);
        });
    }

    public void deleteBookByID(Long id) {
        bookRepository.deleteById(id);
    }
}


