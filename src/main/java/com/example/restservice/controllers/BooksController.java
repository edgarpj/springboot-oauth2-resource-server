package com.example.restservice.controllers;

import com.example.restservice.data.BookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

    @GetMapping
    public ResponseEntity fetchBooks() {
        return new ResponseEntity(Collections.singletonMap("data", "books"), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBook(@RequestBody final BookDto book) {
        return new ResponseEntity(Collections.singletonMap("data", book), HttpStatus.CREATED);
    }
}
