package br.com.project.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.bookstore.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
