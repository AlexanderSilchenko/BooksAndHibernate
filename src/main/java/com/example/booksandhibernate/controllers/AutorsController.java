package com.example.booksandhibernate.controllers;

import com.example.booksandhibernate.model.Autor;
import com.example.booksandhibernate.model.Book;
import com.example.booksandhibernate.services.AutorsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/autor/")
public class AutorsController {
    private final AutorsService autorService;

    @GetMapping
    public List<Autor> getAll() {
        return autorService.findAll();
    }

    @GetMapping("{id}")
    public Autor get(@PathVariable int id) {
        return autorService.find(id);
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        autorService.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,
                       @RequestBody Autor autor) {
        autorService.update(id, autor);
    }

    @PatchMapping("{id}")
    public Autor partialUpdate(@PathVariable int id,
                              @RequestBody Autor autor) {
        return autorService.partialUpdate(id, autor);
    }
}