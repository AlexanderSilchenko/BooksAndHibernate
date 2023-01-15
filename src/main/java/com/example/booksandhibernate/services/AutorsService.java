package com.example.booksandhibernate.services;

import com.example.booksandhibernate.model.Autor;
import com.example.booksandhibernate.model.Book;
import com.example.booksandhibernate.repositores.AutorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AutorsService {
    private final AutorsRepository autorsRepository;
    public List<Autor> findAll() {
        return autorsRepository.findAll();
    }
    public Autor find(int id) {
        return autorsRepository.findById(id).orElseThrow();
    }
    public Autor save(Autor autor) {
        autorsRepository.save(autor);
        return autor;
    }
    public void deleteById(int id) {
        autorsRepository.deleteById(id);
    }
    @Transactional
    public Autor update(int id, Autor autor) {
        return autorsRepository.findById(id).map(tmp -> {
            tmp.setName(autor.getName());
            return tmp;
        }).orElseThrow();
    }
    @Transactional
    public Autor partialUpdate(int id, Autor autor) {
        return autorsRepository.findById(id).map(tmp -> {
            if(autor.getName() != null && !autor.getName().equals(""))
                tmp.setName(autor.getName());
            return tmp;
        }).orElseThrow();
    }
}

