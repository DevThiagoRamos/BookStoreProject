package br.com.project.bookstore.resources;

import br.com.project.bookstore.dtos.BookDTO;
import br.com.project.bookstore.entity.Books;
import br.com.project.bookstore.entity.Category;
import br.com.project.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookResource {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Books> findById(@PathVariable Integer id){
    Books obj = bookService.findById(id);
    return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer id_cat){
        List<Books> list = bookService.findAll(id_cat);
        List<BookDTO> listDTO = list.stream().map(BookDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Books> update(@PathVariable Integer id, @RequestBody Books obj){
        Books newObj = bookService.update(id,obj);
        return ResponseEntity.ok().body(newObj);
    } @PatchMapping(value = "/{id}")
    public ResponseEntity<Books> updatePatch(@PathVariable Integer id, @RequestBody Books obj){
        Books newObj = bookService.update(id,obj);
        return ResponseEntity.ok().body(newObj);
    }
    @PostMapping
    public ResponseEntity<Books> create(@RequestParam (value = "category", defaultValue = "0") Integer id_cat,
            @RequestBody Books obj) {
        Books newObj = bookService.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
        
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
