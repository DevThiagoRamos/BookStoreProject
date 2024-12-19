package br.com.project.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.project.bookstore.entity.Books;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{

    @Query("SELECT obj FROM Books obj WHERE obj.category.id = :id_cat ORDER BY title")
    List<Books> findAllByCategory(@Param(value = "id_cat") Integer id_cat);
}
