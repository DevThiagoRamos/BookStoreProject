package br.com.project.bookstore.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.boot.CommandLineRunner;

import br.com.project.bookstore.entity.Books;
import br.com.project.bookstore.entity.Category;
import br.com.project.bookstore.repositories.BooksRepository;
import br.com.project.bookstore.repositories.CategoryRepository;

@Service
public class DBServicce implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BooksRepository booksRepository;

	public void databaseInstance() {
		booksRepository.deleteAll();
		categoryRepository.deleteAll();

		Category cat1 = new Category(null, "Computing", "Computer Books");
		Category cat2 = new Category(null, "Sci-Fi", "Sci-Fi Books");
		Category cat3 = new Category(null, "Biography", "biography Books");

		Books b1 = new Books(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Books b2 = new Books(null, "Software Engineering", "Louis V. Gerstner", "Lorem Ipsum", cat1);
		Books b3 = new Books(null, "The Time Machine", "H.G. Wells", "Lorem Ipsum", cat2);
		Books b4 = new Books(null, "The War of Worlds", "H.G. Wells", "Lorem Ipsum", cat2);
		Books b5 = new Books(null, "I, Robot", "Isaac Asimov", "Lorem Ipsum", cat2);

		cat1.getBooks().addAll(Arrays.asList(b1, b2));
		cat2.getBooks().addAll(Arrays.asList(b3, b4, b5));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		booksRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));
	}

	@Override
	public void run(String... args) throws Exception {
		databaseInstance();
	}
}
