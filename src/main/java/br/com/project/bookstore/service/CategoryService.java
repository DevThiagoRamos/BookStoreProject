package br.com.project.bookstore.service;

import br.com.project.bookstore.dtos.CategoryDTO;
import br.com.project.bookstore.entity.Category;
import br.com.project.bookstore.repositories.CategoryRepository;
import br.com.project.bookstore.service.exceptions.DataIntegrityViolationException;
import br.com.project.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category findById(Integer id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! ID: " + id + " Tipo: " + Category.class.getName()));
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Category create (Category obj){
        obj.setId(null);
        return categoryRepository.save(obj);
    }

    public Category update(Integer id, CategoryDTO objDTO) {
        Category obj = findById(id);
        obj.setName(objDTO.getName());
        obj.setDescription(objDTO.getDescription());
        return categoryRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoryRepository.deleteById(id);
        }  catch (org.springframework.dao.DataIntegrityViolationException e ){
            throw new DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados");
        }
    }
}
