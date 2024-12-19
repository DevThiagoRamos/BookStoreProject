package br.com.project.bookstore.service;

import br.com.project.bookstore.entity.Books;
import br.com.project.bookstore.entity.Category;
import br.com.project.bookstore.repositories.BooksRepository;
import br.com.project.bookstore.repositories.CategoryRepository;
import br.com.project.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private CategoryService categoryService;
    public Books findById(Integer id){
        Optional<Books> obj = booksRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Livro não encontrado: " + id + " Tipo: " + Books.class.getName()));
    }

    public List<Books> findAll(Integer id_cat) {
        categoryService.findById(id_cat);
        return booksRepository.findAllByCategory(id_cat);
    }

    public Books update(Integer id, Books obj) {
        Books newObj = findById(id);
        updateData(newObj, obj);
        return booksRepository.save(newObj);
    }

    private void updateData(Books newObj, Books obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setAuthor_name(obj.getAuthor_name());
        newObj.setText(obj.getText());
    }

    public Books create(Integer id_cat, Books obj) {
        obj.setId(null);
        Category cat = categoryService.findById(id_cat);
        obj.setCategory(cat);
        return booksRepository.save(obj);
    }

    public void delete(Integer id) {
        Books newObj = findById(id);
        booksRepository.delete(newObj);
    }
}
