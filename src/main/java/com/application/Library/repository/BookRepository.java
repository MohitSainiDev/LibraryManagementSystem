package com.application.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
