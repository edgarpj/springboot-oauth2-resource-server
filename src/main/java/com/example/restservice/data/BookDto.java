package com.example.restservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private String isbn;
    private String name;
    private String Author;

}
