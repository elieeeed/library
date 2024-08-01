package com.jpaLearning.service;

import com.jpaLearning.dto.BookDTO;
import com.jpaLearning.entity.Book;
import com.jpaLearning.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookBusiness {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookBusiness(BookRepository bookRepository,
                        ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public void persist(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        bookRepository.save(book);
    }

    public List<BookDTO> findAll() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    public void update(BookDTO bookDTO) {
        Book book = bookRepository.findBookByBookNumber(bookDTO.getBookNumber());
        if (book != null) {
            book.setName(bookDTO.getName());
            book.setEntryDate(bookDTO.getEntryDate());
            bookRepository.save(book);
        } else {
            Book map = modelMapper.map(bookDTO, Book.class);
            bookRepository.save(map);
        }
    }

    public void delete(Long bookNumber) {
        Book book = bookRepository.findBookByBookNumber(bookNumber);
        bookRepository.delete(book);
    }
}
