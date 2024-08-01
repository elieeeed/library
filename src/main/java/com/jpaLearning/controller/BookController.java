package com.jpaLearning.controller;

import com.jpaLearning.dto.BookDTO;
import com.jpaLearning.service.BookBusiness;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookBusiness bookBusiness;

    public BookController(BookBusiness bookBusiness) {
        this.bookBusiness = bookBusiness;
    }

    @PostMapping("/save")
    public void save(@RequestBody BookDTO bookDTO) {
        bookBusiness.persist(bookDTO);
    }

    @PutMapping("/update")
    public void update(@RequestBody BookDTO bookDTO) {
        bookBusiness.update(bookDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        bookBusiness.delete(id);
    }

    @GetMapping("/find-all")
    public List<BookDTO> findAll() {
        return bookBusiness.findAll();
    }

}
