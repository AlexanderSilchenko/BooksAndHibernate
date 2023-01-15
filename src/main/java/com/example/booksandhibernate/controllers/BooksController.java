package com.example.booksandhibernate.controllers;

import com.example.booksandhibernate.model.Book;
import com.example.booksandhibernate.services.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book/")
public class BooksController {
    private final BooksService booksService;

    @GetMapping
    public List<Book> getAll() {
        return booksService.findAll();
    }

    @GetMapping("{id}")
    public Book get(@PathVariable int id) {
        return booksService.find(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return booksService.save(book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        booksService.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,
                       @RequestBody Book book) {
        booksService.update(id, book);
    }

    @PatchMapping("{id}")
    public Book partialUpdate(@PathVariable int id,
                              @RequestBody Book book) {
        return booksService.partialUpdate(id, book);
    }
}
