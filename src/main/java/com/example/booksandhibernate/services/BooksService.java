package com.example.booksandhibernate.services;

import com.example.booksandhibernate.model.Book;
import com.example.booksandhibernate.repositores.BooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BooksService {
    private final BooksRepository booksRepository;

    public List<Book> findAll() {
        return booksRepository.findAll();
    }
    public Book find(int id) {
        return booksRepository.findById(id).orElseThrow();
    }

    public Book save(Book book) {
        booksRepository.save(book);
        return book;
    }

    public void deleteById(int id) {
        booksRepository.deleteById(id);

    }
    @Transactional
    public Book update(int id, Book book) {
        Optional<Book> updateBook = booksRepository.findById(id);
        updateBook.map(tmp -> {
            tmp.setTitle(book.getTitle());
            tmp.setAutor(book.getAutor());
            tmp.setYear(book.getYear());
            tmp.setGenre(book.getGenre());
            tmp.setPages(book.getPages());
            tmp.setDescription(book.getDescription());
            return tmp;
        });
        return updateBook.orElseThrow();
    }
    @Transactional
    public Book partialUpdate(int id, Book book) {
        return booksRepository.findById(id).map(tmp -> {
            if(book.getTitle() != null && !book.getTitle().equals(""))
                tmp.setTitle(book.getTitle());
            if(book.getAutor() != null)
                tmp.setAutor(book.getAutor());
            if(book.getYear() > 0)
                tmp.setYear(book.getYear());
            if(book.getGenre() != null)
                tmp.setGenre(book.getGenre());
            if(book.getPages() > 0)
                tmp.setPages(book.getPages());
            if(book.getDescription() != null)
                tmp.setDescription(book.getDescription());
            return tmp;
        }).orElseThrow();
    }
}
