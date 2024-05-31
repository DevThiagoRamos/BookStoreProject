package br.com.project.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.bookstore.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{

}
