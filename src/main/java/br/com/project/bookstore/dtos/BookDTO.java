package br.com.project.bookstore.dtos;

import br.com.project.bookstore.entity.Books;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BookDTO implements Serializable {
    private static final long serialVersionUID= 1L;
    private Integer id;
    private String titulo;
    public BookDTO() {
        super();
    }
    public BookDTO(Books obj){
        super();
        this.id = obj.getId();
        this.titulo = obj.getTitle();
    }

}
