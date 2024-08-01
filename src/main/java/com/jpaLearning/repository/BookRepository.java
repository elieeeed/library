package com.jpaLearning.repository;

import com.jpaLearning.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByBookNumber(Long bookNumberId);
}
