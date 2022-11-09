package com.betterworldbook.fakebook.controller;

import com.betterworldbook.fakebook.model.Book;
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
    public Iterable<Book> getAllBooks() {
        return bookService.getAllBooks() ;
    }

    @PostMapping("/books/{categoryId}/books")
    public void createBook(@PathVariable Long categoryId, @RequestBody Book book) {
        bookService.createBook(categoryId,book);
    }

//    @PutMapping("/books/{categoryId}/books")
//    public void updateBook(@PathVariable  Long categoryId,  @RequestBody Books books){
//       bookService.createBook( categoryId, books);
    //}
//    @PutMapping("/books/{categoryId}/books")
//    public void updateBook(@PathVariable Long categoryId, @RequestBody Books books){
//        bookService.createBook(categoryId, books);
//    }
@PutMapping("/books/{categoryId}/books")
public void updateBook (@PathVariable Long categoryId, @RequestBody Book book) {
    bookService.createBook(categoryId,book);
}

    @DeleteMapping("/books/{bookId}")
    public void deleteBookById(@PathVariable Long bookId) {
        bookService.deleteBookByID(bookId);
    }
    @GetMapping("/search")
    public Iterable<Book> searchForBookByName(@RequestParam("query") String search){
        return bookService.searchForBookByName(search);
    }
    }



