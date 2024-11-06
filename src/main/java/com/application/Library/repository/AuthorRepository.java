package com.application.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
