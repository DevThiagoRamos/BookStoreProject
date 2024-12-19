package br.com.project.bookstore.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;


}
