package com.example.booksandhibernate.repositores;

import com.example.booksandhibernate.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorsRepository extends JpaRepository<Autor, Integer> {

}
