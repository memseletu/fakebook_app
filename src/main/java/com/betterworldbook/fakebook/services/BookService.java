package com.betterworldbook.fakebook.services;

import com.betterworldbook.fakebook.model.Book;
import com.betterworldbook.fakebook.model.Category;
import com.betterworldbook.fakebook.repository.BookRepository;
import com.betterworldbook.fakebook.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
   private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<?> getBookById ( Long bookId) {
        Book p = bookRepository.findById(bookId).orElse(null);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }


    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void createBook( Long categoryId, Book books) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        books.setCategory(category);
        bookRepository.save(books);
    }

//    public void createBook( Long categoryId, Books books) {
//        categoryRepository.findById(categoryId).map(category -> {
//            books.setCategory(category);
//            return bookRepository.save(books);
//        });
//    }
//    public void updateBooks(Books books, Long categoryId){
//        categoryRepository.findById(categoryId).map(category -> {
//            books.setCategory(category);
////            Long bookGetId = books.getId();
////            log.info(bookGetId.toString());
//            return bookRepository.save(books);
//        });
//    }

    public void deleteBookByID(Long id) {
        bookRepository.deleteById(id);
    }

    public Iterable<Book> searchForBookByName(String search){
    return bookRepository.searchForBookByName(search);
    }
}


