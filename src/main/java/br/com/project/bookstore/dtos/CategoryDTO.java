package br.com.project.bookstore.dtos;

import br.com.project.bookstore.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID= 1L;

    public CategoryDTO(Category obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    private Integer id;
    private String name;
    private  String description;
}
