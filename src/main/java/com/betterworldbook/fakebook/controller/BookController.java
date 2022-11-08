package com.betterworldbook.fakebook.controller;

import com.betterworldbook.fakebook.model.Books;
import com.betterworldbook.fakebook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("books/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("/books")
    public Iterable<Books> getAllBooks() {
        return bookService.getAllBooks() ;
    }

    @PostMapping("/books/{categoryId}/books")
    public void createBook(@PathVariable (value = "categoryId") Long categoryId, @RequestBody Books book) {
        bookService.createBook(categoryId,book);
    }

    @PutMapping("/books/{categoryId}/books")
    public void updateBook(@PathVariable (value =  "categoryId") Long categoryId, @RequestBody Books books){
       bookService.updateBooks(categoryId,books);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBookById(@PathVariable Long bookId) {
        bookService.deleteBookByID(bookId);
    }


}
